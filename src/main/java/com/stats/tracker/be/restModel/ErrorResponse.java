package com.stats.tracker.be.restModel;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private int errorCode;
    private HttpStatus errorStatus;
    private String errorMex;

//    public ErrorResponse(int errorCode, String errorMex) {
//        this.errorCode = errorCode;
//        this.errorMex = errorMex;
//    }
    public ErrorResponse(HttpStatus httpStatus, String errorMex) {
        this.errorCode = httpStatus.value();
        this.errorStatus = httpStatus;
        this.errorMex = errorMex;
    }
    public ErrorResponse(HttpStatus httpStatus, Throwable t) {
        this.errorCode = httpStatus.value();
        this.errorStatus = httpStatus;
        this.errorMex = t.toString();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(HttpStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMex() {
        return errorMex;
    }
    public void setErrorMex(String errorMex) {
        this.errorMex = errorMex;
    }

}
