package com.example.vp_a4.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Invalid user credentials exception");
    }
}
