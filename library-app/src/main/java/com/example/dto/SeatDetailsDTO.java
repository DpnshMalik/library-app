package com.example.dto;

import java.util.List;

public class SeatDetailsDTO {
    private int seatNumber;
    private String seatType;
    private List<SlotAssignmentDTO> assignments;

    public SeatDetailsDTO() {}

    public SeatDetailsDTO(int seatNumber, String seatType, List<SlotAssignmentDTO> assignments) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.assignments = assignments;
    }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }

    public List<SlotAssignmentDTO> getAssignments() { return assignments; }
    public void setAssignments(List<SlotAssignmentDTO> assignments) { this.assignments = assignments; }
}
