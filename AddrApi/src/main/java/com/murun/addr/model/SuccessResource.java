package com.murun.addr.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.time.LocalDateTime;

/**
 * Created by mark on 3/29/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessResource {

    private String code;
    private String message;
    private LocalDateTime dateTime = LocalDateTime.now();


    public SuccessResource(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
