package com.example.exception;

public class InvalidAssignmentException extends RuntimeException {
    public InvalidAssignmentException(String message) {
        super(message);
    }
} 