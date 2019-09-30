package com.citytransportsystem.exception;

public class RouteException extends Exception {
    public RouteException() {
    }

    public RouteException(String message) {
        super(message);
    }

    public RouteException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
