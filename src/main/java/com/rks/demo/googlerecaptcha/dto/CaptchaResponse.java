package com.rks.demo.googlerecaptcha.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class CaptchaResponse {

    private Boolean success;
    private Date timestamp;
    private String hostname;
    @JsonProperty("error-codes")
    private List<String> errorCodes;

    public Boolean getSuccess() {
        return success;
    }

    public String getHostname() {
        return hostname;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }
}
