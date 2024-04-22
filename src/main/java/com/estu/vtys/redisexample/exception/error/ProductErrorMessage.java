package com.estu.vtys.redisexample.exception.error;

public enum ProductErrorMessage {

    PRODUCT_NOT_FOUND_MESSAGE("The product is not found!"),
    OUT_OF_STOCK_MESSAGE("The product with ID %s is out of stock!")
    ;

    private final String message;

    ProductErrorMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage(String productId) {
        return String.format(message, productId);
    }

    @Override
    public String toString() {
        return message;
    }
}
