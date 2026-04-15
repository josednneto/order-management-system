package com.ordersystem.model.exceptions;

public class OrderAlreadyExistsException extends OrderException {
    public OrderAlreadyExistsException() {
        super("Order already exists");
    }
}
