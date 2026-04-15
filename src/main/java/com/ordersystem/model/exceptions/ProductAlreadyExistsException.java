package com.systemdelivery.model.exceptions;

public class ProductAlreadyExistsException extends OrderException {
    public ProductAlreadyExistsException() {
        super("Product already exists");
    }
}
