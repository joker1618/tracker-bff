package com.stats.tracker.be.restModel;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private int statusCode;
    private String error;

    public ErrorResponse(int statusCode, String error) {
        this.statusCode = statusCode;
        this.error = error;
    }
    public ErrorResponse(HttpStatus httpStatus, String error) {
        this.statusCode = httpStatus.value();
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

}