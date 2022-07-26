package com.pref.core.entity.inisis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@ToString
@Getter
public class CreditCardResponse extends GeneralResponse {

    @Length(max = 16)
    @JsonProperty("CARD_NUM")
    private String cardNum;

    // 상점부담 무이자 할부여부 ["1": 상점부담 무이자]
    @Length(max = 1)
    @JsonProperty("CARD_Interest")
    private String interest;

    @Length(max = 2)
    @JsonProperty("CARD_Quota")
    private String quota;

    @Length(max = 2)
    @JsonProperty("CARD_Code")
    private String code;

    @Length(max = 1)
    @JsonProperty("CARD_CorpFlag")
    private String corpFlag;

    @Length(max = 1)
    @JsonProperty("CARD_CheckFlag")
    private String checkFlag;

    @Length(max = 1)
    @JsonProperty("CARD_PRTC_CODE")
    private String prtcCode;

    @Length(max = 2)
    @JsonProperty("CARD_BankCode")
    private String bankCode;

    @Length(max = 1)
    @JsonProperty("CARD_SrcCode")
    private String srcCode;

    @Length(max = 1)
    @JsonProperty("CARD_Point")
    private String point;

    @Length(max = 12)
    @JsonProperty("CARD_UsePoint")
    private String usePoint;

    @JsonProperty("CARD_CouponPrice")
    private String couponPrice;

    @JsonProperty("CARD_CouponDiscount")
    private String couponDiscount;

    @Length(max = 12)
    @JsonProperty("NAVERPOINT_UseFreePoint")
    private String naverUseFreePoint;

    @Length(max = 1)
    @JsonProperty("NAVERPOINT_CSHRApplYN")
    private String naverCshrApplYn;

    @Length(max = 12)
    @JsonProperty("NAVERPOINT_CSHRApplAmt")
    private String naverCshrApplAmt;

    @JsonProperty("PCO_OrderNo")
    private String pcoOrderNo;

    @Length(max = 3)
    @JsonProperty("currency")
    private String currency;

    @JsonProperty("OrgPrice")
    private String orgPrice;

    @Length(max = 40)
    @JsonProperty("CARD_Billkey")
    private String billkey;

}
