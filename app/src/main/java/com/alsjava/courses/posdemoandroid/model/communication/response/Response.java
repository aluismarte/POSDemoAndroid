package com.alsjava.courses.posdemoandroid.model.communication.response;

/**
 * Created by aluis on 11/9/19.
 */
public abstract class Response {

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
