package com.example.pharmacy.exception;

public class NotFoundByAddress extends RuntimeException{
    public NotFoundByAddress(String message) {
        super(message);
    }
}
