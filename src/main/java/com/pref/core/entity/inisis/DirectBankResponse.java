package com.pref.core.entity.inisis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class DirectBankResponse extends GeneralResponse {

    @Length(max = 2)
    @JsonProperty("ACCT_BankCode")
    private String acctBankCode;

    @Length(max = 6)
    @JsonProperty("CSHR_ResultCode")
    private String cshrResultCode;

    @Length(max = 1)
    @JsonProperty("CSHR_Type")
    private String cshrType;

    @Length(max = 30)
    @JsonProperty("ACCT_Name")
    private String acctName;

}
