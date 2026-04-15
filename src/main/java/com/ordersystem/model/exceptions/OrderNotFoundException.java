package com.ordersystem.model.exceptions;

public class OrderNotFoundException extends OrderException {
    public OrderNotFoundException() {
        super("Order not found!");
    }
}
