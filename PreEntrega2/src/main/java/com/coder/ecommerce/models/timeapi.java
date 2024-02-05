package com.coder.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class timeapi {
    private String date;
    private String dateTime;

    public String getDate() {
        return date;
    }
    public String getDateTime() {
        return dateTime;
    }
}
