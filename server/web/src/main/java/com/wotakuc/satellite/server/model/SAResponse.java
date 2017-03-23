package com.wotakuc.satellite.server.model;

public class SAResponse {
    public boolean success;
    public String data;
    public String message;

    public SAResponse(boolean success, String data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }
}
