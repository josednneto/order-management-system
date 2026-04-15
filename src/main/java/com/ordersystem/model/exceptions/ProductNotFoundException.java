package com.ordersystem.model.exceptions;

public class ProductNotFoundException extends OrderException {
    public ProductNotFoundException() {
        super("Product not found!");
    }
}
