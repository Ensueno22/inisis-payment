package com.pref.core.parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pref.client.InisisClient;
import com.pref.core.entity.inisis.*;
import com.pref.core.utils.SHA256;
import com.pref.exception.PaymentNetCancelException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class OnlinePayment implements Payment {

    private static final String SUCCESS = "0000";

    private final ObjectMapper mapper = new ObjectMapper();

    private final SHA256 sha256;

    private final InisisClient inisisClient;

    @Override
    public boolean approveRequest(Map<String, String> request) {

        try {
            ApprovalResponse data = mapper.convertValue(request, ApprovalResponse.class);

            if (data.getResultCode().equals(SUCCESS)) {
                final String authUrl = data.getAuthUrl();
                final String cancelUrl = data.getNetCancelUrl();

                final String timestamp = String.valueOf(System.currentTimeMillis());
                final String signature = NVPStringBuilder(data.getAuthToken(), timestamp);

                Map<String, String> authRequest = mapper.convertValue(approvalRequestBuilder(data, timestamp, signature), Map.class);

                try {
                    // 어떤 타입으로 결제 될지 모르기 때문에 모든 타입을 다 받아야 한다.
                    String json = inisisClient.approvalPayment(new URI(authUrl), authRequest);
                    GeneralResponse authResponse = mapper.readValue(json, GeneralResponse.class);

                    if (authResponse.getResultCode().equals(SUCCESS)) {
                        final String payMethod = authResponse.getPayMethod();
                        if (payMethod.contains("Card")) {
                            CreditCardResponse saveCreditCard = mapper.readValue(json, CreditCardResponse.class);
                            log.info("saveCreditCard=[{}]", saveCreditCard);
                            // 여기에서 db에 저장 한다.
                        } else if (payMethod.equals("DirectBank")) {
                            DirectBankResponse saveDirectBank = mapper.readValue(json, DirectBankResponse.class);
                            log.info("saveDirectBank=[{}]", saveDirectBank);
                        } else if (payMethod.equals("VBank")){
                            VBankResponse saveVBankResponse = mapper.readValue(json, VBankResponse.class);
                            log.info("saveVBank=[{}]", saveVBankResponse);
                        } else {
                            log.info("Unknown Payment Type=[{}]", payMethod);
                        }

                        return true;
                    } else {
                        log.error("취소 코드 발생되도록 유도 해야함");
                        throw new PaymentNetCancelException("결제 실패 하였습니다.");
                    }
                } catch (Exception e) {
                    String failedResponse = inisisClient.cancelPayment(new URI(cancelUrl), authRequest);
                    log.error("failedResponse=[{}]", failedResponse);
                }
            } else {
                log.error("error code={} message={}", data.getResultCode(), data.getResultMsg());
            }
        } catch(Exception e) {
            log.error("여기서는 단순 실패 처리가 맞음");
        }

        return false;
    }

    @Override
    public void afterApproval(String response) {

    }

    public String NVPStringBuilder(String authToken, String timestamp) {
        return "authToken=" + authToken + "&timestamp=" + timestamp;
    }

    private ApprovalRequest approvalRequestBuilder(ApprovalResponse data, String timestamp, String signature) throws NoSuchAlgorithmException {
        return ApprovalRequest.builder()
                .mid(data.getMid())
                .authToken(data.getAuthToken())
                .timestamp(timestamp)
                .signature(sha256.encrypt(signature))
                .charset(data.getCharset())
                .format("JSON")
                .build();
    }
}
