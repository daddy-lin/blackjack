package com.dannio.blackjack.exception;

import com.dannio.blackjack.param.base.RestResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BlackExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BlackException.class)
    protected ResponseEntity<Object> handleBlackException(BlackException e, WebRequest request) {

        return handleExceptionInternal(e, RestResponse.fail(e.getMessage()), new HttpHeaders(), HttpStatus.OK, request);
    }
}
