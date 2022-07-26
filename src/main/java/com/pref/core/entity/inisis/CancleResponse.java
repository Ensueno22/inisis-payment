package com.pref.core.entity.inisis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@ToString
@Getter
public class CancleResponse {

    @Length(max = 10)
    @JsonProperty("resultCode")
    private String resultCode;

    @Length(max = 100)
    private String resultMsg;

    @Length(max = 20)
    private String timestamp;

    @Length(max = 40)
    private String tid;

    @Length(max = 10)
    private String mid;

    @Length(max = 40)
    @JsonProperty("MOID")
    private String moid;

    @Length(max = 10)
    private String selectPayMethod;

}
