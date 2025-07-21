package com.example.exception;

public class SeatAlreadyAssignedException extends RuntimeException {
    public SeatAlreadyAssignedException(String message) {
        super(message);
    }
} 