package com.challenge.matomogenerator.exception;

public class DuplicateException extends RuntimeException {
    private String message;

    public DuplicateException(String message)
    {
        super(message);
        this.message = message;
    }
    public DuplicateException() {}
}
