package com.ordersystem.model.exceptions;

public class InsufficientStockException extends OrderException {
    public InsufficientStockException() {
        super("Stock insufficient!");
    }
}
