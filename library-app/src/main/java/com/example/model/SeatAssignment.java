package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "seatAssignments")
public class SeatAssignment {
    @Id
    private String id;

    private String seatId;     // Reference to Seat
    private String studentId;  // Reference to Student
    private String slotId;     // Reference to Slot
    private Date startDate;    // Assignment start date
    private Date endDate;      // Assignment end date

    // Constructors
    public SeatAssignment() {}

    public SeatAssignment(String seatId, String studentId, String slotId, Date startDate, Date endDate) {
        this.seatId = seatId;
        this.studentId = studentId;
        this.slotId = slotId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSeatId() { return seatId; }
    public void setSeatId(String seatId) { this.seatId = seatId; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getSlotId() { return slotId; }
    public void setSlotId(String slotId) { this.slotId = slotId; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
}