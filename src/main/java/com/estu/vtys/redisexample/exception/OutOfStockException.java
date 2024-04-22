package com.estu.vtys.redisexample.exception;

public class OutOfStockException extends ShoppingCartException {
    public OutOfStockException(String message) {
        super(message);
    }
}
