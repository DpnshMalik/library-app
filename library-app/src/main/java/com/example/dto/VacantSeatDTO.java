package com.example.dto;

public class VacantSeatDTO {
    private String seatId;
    private int seatNumber;
    private String seatType;

    public VacantSeatDTO() {}

    public VacantSeatDTO(String seatId, int seatNumber, String seatType) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public String getSeatId() { return seatId; }
    public void setSeatId(String seatId) { this.seatId = seatId; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }
} 