package com.ordersystem.model.exceptions;

public abstract class OrderException extends RuntimeException {
    public OrderException(String message) {
        super(message);
    }
}
