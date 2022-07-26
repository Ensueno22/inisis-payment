package com.pref.core.entity.inisis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralResponse {

    @NotNull
    @Length(max = 6)
    @JsonProperty("resultCode")
    private String resultCode;

    @Length(max = 100)
    @JsonProperty("resultMsg")
    private String resultMsg;

    @Length(max = 40)
    @JsonProperty("tid")
    private String tid;

    @Length(max = 40)
    @JsonProperty("goodName")
    private String goodName;

    @Length(max = 20)
    @JsonProperty("TotPrice")
    private String totPrice;

    @Length(max = 40)
    @JsonProperty("MOID")
    private String moid;

    @JsonProperty("payMethod")
    private String payMethod;

    @Length(max = 8)
    @JsonProperty("applNum")
    private String applNum;

    @Length(max = 8)
    @JsonProperty("applDate")
    private String applDate;

    @Length(max = 6)
    @JsonProperty("applTime")
    private String applTime;

    @Length(max = 2)
    @JsonProperty("EventCode")
    private String eventCode;

    @Length(max = 30)
    @JsonProperty("buyerName")
    private String buyerName;

    @Length(max = 20)
    @JsonProperty("buyerTel")
    private String buyerTel;

    @Length(max = 60)
    @JsonProperty("buyerEmail")
    private String buyerEmail;

    @Length(max = 60)
    @JsonProperty("custEmail")
    private String custEmail;
}
