package com.ordersystem.model.exceptions;

public class InvalidProductException extends OrderException {
    public InvalidProductException() {
        super("Product cannot be null");
    }
}
