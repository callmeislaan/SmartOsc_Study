package com.practice.crudproduct.exception;

public class OrderDetailsNotFoundException extends RuntimeException{

    public OrderDetailsNotFoundException() {
        super();
    }

    public OrderDetailsNotFoundException(String message) {
        super(message);
    }
}
