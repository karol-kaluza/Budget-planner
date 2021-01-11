package com.planner.user.model;

public class PlainResponse {
    private String message;

    public PlainResponse() {
    }

    public PlainResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
