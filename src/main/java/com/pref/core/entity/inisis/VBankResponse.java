package com.pref.core.entity.inisis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class VBankResponse extends GeneralResponse {

    @Length(max = 14)
    @JsonProperty("VACT_Num")
    private String vactNum;

    @Length(max = 2)
    @JsonProperty("VACT_BankCode")
    private String vactBankCode;

    @JsonProperty("vactBankName")
    private String vactBankName;

    @Length(max = 20)
    @JsonProperty("VACT_Name")
    private String vactName;

    @Length(max = 8)
    @JsonProperty("VACT_InputName")
    private String vactDate;

    @Length(max = 6)
    @JsonProperty("VACT_Time")
    private String vactTime;

}
