package com.systemdelivery.model.exceptions;

public class InsufficientStockException extends OrderException {
    public InsufficientStockException() {
        super("Stock insufficient!");
    }
}
