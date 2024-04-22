package com.estu.vtys.redisexample.exception;

public class ShoppingCartException extends RuntimeException {
    public ShoppingCartException() {
        super();
    }

    public ShoppingCartException(String message) {
        super(message);
    }
}
