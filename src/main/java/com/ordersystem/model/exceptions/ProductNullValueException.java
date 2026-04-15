package com.systemdelivery.model.exceptions;

public class ProductNullValueException extends OrderException {
    public ProductNullValueException() {
        super("Product ID cannot be null");
    }
}
