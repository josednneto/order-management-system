package com.ordersystem.model.exceptions;

public class InvalidQuantityException extends OrderException {
    public InvalidQuantityException() {
        super("Invalid quantity");
    }
}
