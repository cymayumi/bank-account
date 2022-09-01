package com.api.bankaccount.exceptionHandler;

public class InsufficientCashException extends Exception {
    public InsufficientCashException(String message) {
        super(message);
    }
}