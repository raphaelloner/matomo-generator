package com.challenge.matomogenerator.exception;

public class DuplicateException extends RuntimeException {
    private String message;

    public DuplicateException(String msg)
    {
        super(msg);
        this.message = msg;
    }
    public DuplicateException() {}
}
