package com.example.pharmacy.exception;

public class NotFoundByName extends  RuntimeException{
    public NotFoundByName(String message) {
        super(message);
    }
}
