package com.pref.core.entity.inisis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ApprovalRequest {

    @Length(max = 10)
    @JsonProperty("mid")
    private String mid;

    @JsonProperty("authToken")
    private String authToken;

    @Length(max = 20)
    @JsonProperty("timestamp")
    private String timestamp;

    @Length(max = 60)
    @JsonProperty("signature")
    private String signature;

    @Length(max = 6)
    @JsonProperty("charset")
    private String charset;

    @Length(max = 5)
    @JsonProperty("format")
    private String format;

    @Length(max = 64)
    @JsonProperty("price")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String price;

    private String authUrl;

}
