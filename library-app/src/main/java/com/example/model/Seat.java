package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seats")
public class Seat {
    @Id
    private String id;

    private int seatNumber;
    private String seatType; // e.g., regular, premium, etc.

    // Constructors
    public Seat() {}

    public Seat(int seatNumber, String seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }
}