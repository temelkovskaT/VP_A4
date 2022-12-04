package com.example.vp_a4.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{

    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }
}
