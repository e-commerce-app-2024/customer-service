package com.ecommerce.app.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String id) {
        super(String.format("Customer not found with id: %s", id));
    }
}
