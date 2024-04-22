package com.estu.vtys.redisexample.exception;

public class ProductNotFoundException extends ShoppingCartException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
