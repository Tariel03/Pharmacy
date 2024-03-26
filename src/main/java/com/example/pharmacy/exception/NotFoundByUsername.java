package com.example.pharmacy.exception;

public class NotFoundByUsername extends RuntimeException{
    public NotFoundByUsername(String message) {
        super(message);
    }
}
