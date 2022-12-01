package com.epam.hackathon.emotional.help.exception;

public class UsernameOrPasswordIncorrectException extends RuntimeException {
    public UsernameOrPasswordIncorrectException(String message) {
        super(message);
    }
}
