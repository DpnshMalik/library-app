package com.example.dto;

public class SlotAssignmentDTO {
    private String slotName;
    private String studentName;
    private String slotId;
    private String studentId;

    public SlotAssignmentDTO() {}

    public SlotAssignmentDTO(String slotName, String studentName, String slotId, String studentId) {
        this.slotName = slotName;
        this.studentName = studentName;
        this.slotId = slotId;
        this.studentId = studentId;
    }

    public String getSlotName() { return slotName; }
    public void setSlotName(String slotName) { this.slotName = slotName; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getSlotId() { return slotId; }
    public void setSlotId(String slotId) { this.slotId = slotId; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
} 