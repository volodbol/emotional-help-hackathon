package com.epam.hackathon.emotional.help.handler;

import com.epam.hackathon.emotional.help.exception.EmailNotAvailableException;
import com.epam.hackathon.emotional.help.exception.PasswordNotValidException;
import com.epam.hackathon.emotional.help.exception.UsernameNotAvailableException;
import com.epam.hackathon.emotional.help.exception.UsernameOrPasswordIncorrectException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthenticationResponseExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            UsernameNotAvailableException.class,
            EmailNotAvailableException.class,
            PasswordNotValidException.class
    })
    public ResponseEntity<Object> handleNotAvailable(RuntimeException e, WebRequest webRequest) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(UsernameOrPasswordIncorrectException.class)
    public ResponseEntity<Object> handleIncorrect(RuntimeException e, WebRequest webRequest) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

}
