package com.ecommerce.app.exception;

public class CustomerExistsException extends RuntimeException {

    public CustomerExistsException(String email) {
        super(String.format("Customer exists with email: %s", email));
    }
}
