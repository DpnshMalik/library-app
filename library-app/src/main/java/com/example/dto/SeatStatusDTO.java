package com.example.dto;

public class SeatStatusDTO {
    private String seatId;
    private int seatNumber;
    private String seatType;
    private String status; // "occupied" or "vacant"
    private String studentId;
    private String studentName;

    public SeatStatusDTO() {}

    public SeatStatusDTO(String seatId, int seatNumber, String seatType, String status, String studentId, String studentName) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.status = status;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getSeatId() { return seatId; }
    public void setSeatId(String seatId) { this.seatId = seatId; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public String getSeatType() { return seatType; }
    public void setSeatType(String seatType) { this.seatType = seatType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
} 