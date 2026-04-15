package com.systemdelivery.model.exceptions;

public class InputInvalidValueException extends RuntimeException {
    public InputInvalidValueException() {
        super("Invalid value!");
    }
}
