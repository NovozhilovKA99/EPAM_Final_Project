package com.citytransportsystem.exception;

public class TransportException extends Exception {
    public TransportException() {
    }

    public TransportException(String message) {
        super(message);
    }

    public TransportException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
