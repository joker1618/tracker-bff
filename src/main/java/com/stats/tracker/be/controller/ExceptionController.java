package com.stats.tracker.be.controller;

import com.stats.tracker.be.exception.GenericException;
import com.stats.tracker.be.restModel.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleRestError(Exception ex) {
        logger.error("Handling Exception", ex);
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(error.getStatusCode()).body(error);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponse> handleRestErrorGen(GenericException ex) {
        logger.error("Handling Generic Exception: " + ex.getMessage(), ex);
        if(ex.getCause() != null) {
            logger.error("Caused by: " + ex.getCause(), ex.getCause());
        }
        ErrorResponse error = new ErrorResponse(ex.getStatus(), ex.getMessage());
        return ResponseEntity.status(error.getStatusCode()).body(error);
    }

}