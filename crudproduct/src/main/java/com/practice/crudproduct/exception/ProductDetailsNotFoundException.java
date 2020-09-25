package com.practice.crudproduct.exception;

public class ProductDetailsNotFoundException extends RuntimeException{
    public ProductDetailsNotFoundException() {
        super();
    }

    public ProductDetailsNotFoundException(String message) {
        super(message);
    }
}
