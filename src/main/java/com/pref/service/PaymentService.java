package com.pref.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pref.client.InisisClient;
import com.pref.core.entity.inisis.*;
import com.pref.core.parse.*;
import com.pref.core.utils.SHA256;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

    private static final String SUCCESS = "0000";
    private static final String APPLICATION_JSON = "JSON";

    private final InisisClient inisisClient;

    private final SHA256 sha256;

    private final PaymentProvider provider;

    public void payInisisPayment(Map<String, String> body, boolean isMobile) {
        try {
            Payment paymentParser = provider.getPaymentParser(isMobile);
            boolean result = paymentParser.approveRequest(body);
            log.info("result={}", result);
        } catch (Exception e) {
            log.error("Exception", e);
        }
    }

}
