package com.pref.exception;

public class PaymentNetCancelException extends RuntimeException {

    public PaymentNetCancelException(String message) {
        super(message);
    }

    public PaymentNetCancelException(String message, Throwable cause) {
        super(message, cause);
    }
}
