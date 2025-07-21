package com.example.service;

import com.example.model.SeatAssignment;
import java.util.Date;
import java.util.List;

public interface SeatAssignmentService {
    // Assign a seat to a student for a specific slot and date range
    SeatAssignment assignSeat(String seatId, String studentId, String slotId, Date startDate, Date endDate);

    // Check if a seat is available for a slot and date range
    boolean isSeatAvailable(String seatId, String slotId, Date startDate, Date endDate);

    // Get all assignments for a seat (optionally filtered by slot and date)
    List<SeatAssignment> getAssignmentsForSeat(String seatId, String slotId, Date date);

    // Get all assignments for a slot and date
    List<SeatAssignment> getAssignmentsForSlot(String slotId, Date date);
} 