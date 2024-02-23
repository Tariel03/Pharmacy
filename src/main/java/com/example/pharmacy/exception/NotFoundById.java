package com.example.pharmacy.exception;

public class NotFoundById extends RuntimeException{
    public NotFoundById(String message) {
        super(message);
    }
}
