package com.pref.core.entity.inisis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@ToString
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApprovalResponse {

    @Length(max = 10)
    @JsonProperty("resultCode")
    private String resultCode;

    @Length(max = 100)
    @JsonProperty("resultMsg")
    private String resultMsg;

    @JsonProperty("returnUrl")
    private String returnUrl;

    @Length(max = 10)
    @JsonProperty("mid")
    private String mid;

    @Length(max = 40)
    @JsonProperty("orderNumber")
    private String orderNumber;

    @JsonProperty("authToken")
    private String authToken;

    @JsonProperty("authUrl")
    private String authUrl;

    @Length(max = 64)
    @JsonProperty("netCancelUrl")
    private String netCancelUrl;

    @Length(max = 6)
    @JsonProperty("charset")
    private String charset;

    @Length(max = 16)
    @JsonProperty("cardnum")
    private String cardnum;

    @JsonProperty("checkAckUrl")
    private String checkAckUrl;

    @Length(max = 2000)
    @JsonProperty("merchantData")
    private String merchantData;

}
