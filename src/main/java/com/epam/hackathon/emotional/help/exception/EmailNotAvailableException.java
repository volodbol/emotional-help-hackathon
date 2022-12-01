package com.epam.hackathon.emotional.help.exception;

public class EmailNotAvailableException extends RuntimeException{
    public EmailNotAvailableException(String message) {
        super(message);
    }
}
