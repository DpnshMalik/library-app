package com.example.dto;

public class SlotAssignmentDetailsDTO {
    private String seatId;
    private int seatNumber;
    private String studentId;
    private String studentName;
    private String slotId;
    private String slotName;

    public SlotAssignmentDetailsDTO() {}

    public SlotAssignmentDetailsDTO(String seatId, int seatNumber, String studentId, String studentName, String slotId, String slotName) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.studentId = studentId;
        this.studentName = studentName;
        this.slotId = slotId;
        this.slotName = slotName;
    }

    public String getSeatId() { return seatId; }
    public void setSeatId(String seatId) { this.seatId = seatId; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getSlotId() { return slotId; }
    public void setSlotId(String slotId) { this.slotId = slotId; }

    public String getSlotName() { return slotName; }
    public void setSlotName(String slotName) { this.slotName = slotName; }
}
