package com.ordersystem.model.exceptions;

public class ProductNullValueException extends OrderException {
    public ProductNullValueException() {
        super("Product ID cannot be null");
    }
}
