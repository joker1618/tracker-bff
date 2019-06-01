package com.stats.tracker.be.restModel;

import org.springframework.http.HttpStatus;

public class RestResponse<T> {

    private HttpStatus status;
    private RestError error;
    private T content;

    private RestResponse(HttpStatus status, RestError error, T content) {
        this.status = status;
        this.error = error;
        this.content = content;
    }

    public static <T> RestResponse<T> ok(T content) {
        return new RestResponse<>(HttpStatus.OK, null, content);
    }

    public static class RestError {
        private String errorMex;
        private Throwable cause;

        public String getErrorMex() {
            return errorMex;
        }

        public void setErrorMex(String errorMex) {
            this.errorMex = errorMex;
        }

        public Throwable getCause() {
            return cause;
        }

        public void setCause(Throwable cause) {
            this.cause = cause;
        }
    }
}
