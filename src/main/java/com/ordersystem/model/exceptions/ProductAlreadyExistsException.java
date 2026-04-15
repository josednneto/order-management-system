package com.ordersystem.model.exceptions;

public class ProductAlreadyExistsException extends OrderException {
    public ProductAlreadyExistsException() {
        super("Product already exists");
    }
}
