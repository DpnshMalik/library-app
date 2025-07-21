package com.example.repository;

import com.example.model.SeatAssignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Date;
import java.util.List;

public interface SeatAssignmentRepository extends MongoRepository<SeatAssignment, String> {
    // Find assignments for a seat and slot where the date ranges overlap
    List<SeatAssignment> findBySeatIdAndSlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        String seatId, String slotId, Date endDate, Date startDate
    );

    // Find all assignments for a seat
    List<SeatAssignment> findBySeatId(String seatId);

    // Find all assignments for a slot and date
    List<SeatAssignment> findBySlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        String slotId, Date endDate, Date startDate
    );

    // Find assignments for a seat where the date ranges overlap
    List<SeatAssignment> findBySeatIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        String seatId, Date endDate, Date startDate
    );
    
    //To find existing assignments for a student, slot, and overlapping date range:
    List<SeatAssignment> findByStudentIdAndSlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
    	    String studentId, String slotId, Date endDate, Date startDate
    );
} 