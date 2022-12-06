package com.epam.hackathon.emotional.help.controller.handler;

import com.epam.hackathon.emotional.help.exception.EmotionalMapNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmotionalMapResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EmotionalMapNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(RuntimeException e, WebRequest webRequest) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }

}
