package com.pref.core.entity.inisis.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class MobileApprovalResponse {

    @Length(max = 4)
    @JsonProperty("P_STATUS")
    private String resultCode;

    @Length(max = 10)
    @JsonProperty("P_RMESG1")
    private String resultMsg;

    @Length(max = 40)
    @JsonProperty("P_TID")
    private String tid;

    @Length(max = 8)
    @JsonProperty("P_AMT")
    private String amt;

    @JsonProperty("P_REQ_URL")
    private String reqUrl;

    @Length(max = 600)
    @JsonProperty("P_NOTI")
    private String noti;

}
