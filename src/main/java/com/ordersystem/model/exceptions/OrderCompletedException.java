package com.ordersystem.model.exceptions;

public class OrderCompletedException extends OrderException {
    public OrderCompletedException() {
        super("Order has already been completed!");
    }
}
