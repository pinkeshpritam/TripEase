package com.example.tripease.Exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String invaildCustomerId) {
        super(invaildCustomerId);

    }
}
