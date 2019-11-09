package com.alsjava.courses.posdemoandroid.model.communication.response;

/**
 * Created by aluis on 11/9/19.
 */
public abstract class Response {

    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
