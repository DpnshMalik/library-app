package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SeatAlreadyAssignedException.class)
    public ResponseEntity<String> handleSeatAlreadyAssigned(SeatAlreadyAssignedException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidAssignmentException.class)
    public ResponseEntity<String> handleInvalidAssignment(InvalidAssignmentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // You can add more handlers for other custom exceptions as needed
}
