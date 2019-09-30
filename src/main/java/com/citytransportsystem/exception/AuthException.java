package com.citytransportsystem.exception;

public class AuthException extends RuntimeException {

    AuthException(Throwable cause){
        super("Вы не авторизованы", cause);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
