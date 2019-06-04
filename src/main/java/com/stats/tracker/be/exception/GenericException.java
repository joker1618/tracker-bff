package com.stats.tracker.be.exception;

import org.springframework.http.HttpStatus;

import static xxx.joker.libs.core.utils.JkStrings.strf;

public class GenericException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;
    private String errorMessage;
    private Throwable cause;

    public GenericException() {

    }
    public GenericException(HttpStatus status, String mexFormat, Object... params) {
        this.status = status;
        this.errorMessage = strf(mexFormat, params);
    }
    public GenericException(String mexFormat, Object... params) {
        this.status = HttpStatus.BAD_REQUEST;
        this.errorMessage = strf(mexFormat, params);
    }
    public GenericException(Throwable t, String mexFormat, Object... params) {
        this.status = HttpStatus.BAD_REQUEST;
        this.errorMessage = strf(mexFormat, params);
        this.cause = t;
    }
    public GenericException(Throwable t, HttpStatus status, String mexFormat, Object... params) {
        this.status = status;
        this.errorMessage = strf(mexFormat, params);
        this.cause = t;
    }

    public String getMessage() {
        return errorMessage;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public Throwable getCause() {
        return cause;
    }


}