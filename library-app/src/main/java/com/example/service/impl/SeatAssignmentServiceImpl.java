package com.example.service.impl;

import com.example.model.SeatAssignment;
import com.example.repository.SeatAssignmentRepository;
import com.example.service.SeatAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeatAssignmentServiceImpl implements SeatAssignmentService {

    @Autowired
    private SeatAssignmentRepository seatAssignmentRepository;

    @Override
    public SeatAssignment assignSeat(String seatId, String studentId, String slotId, Date startDate, Date endDate) {
        if (!isSeatAvailable(seatId, slotId, startDate, endDate)) {
            // Seat is not available for the given slot and date range
            return null;
        }
        SeatAssignment assignment = new SeatAssignment(seatId, studentId, slotId, startDate, endDate);
        return seatAssignmentRepository.save(assignment);
    }

    @Override
    public boolean isSeatAvailable(String seatId, String slotId, Date startDate, Date endDate) {
        // Check for overlapping assignments
        List<SeatAssignment> overlappingAssignments = seatAssignmentRepository
            .findBySeatIdAndSlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                seatId, slotId, endDate, startDate
            );
        return overlappingAssignments == null || overlappingAssignments.isEmpty();
    }

    @Override
    public List<SeatAssignment> getAssignmentsForSeat(String seatId, String slotId, Date date) {
        // If slotId is provided, filter by slot; otherwise, get all for seat
        if (slotId != null && date != null) {
            // Find assignments for this seat, slot, and date
            return seatAssignmentRepository.findBySeatIdAndSlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                seatId, slotId, date, date
            );
        } else if (slotId != null) {
            // Find all assignments for this seat and slot
            return seatAssignmentRepository.findBySeatIdAndSlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                seatId, slotId, new Date(Long.MAX_VALUE), new Date(0)
            );
        } else {
            // Find all assignments for this seat
            // (Assuming a method exists or you can add one in the repository)
            return seatAssignmentRepository.findBySeatId(seatId);
        }
    }

    @Override
    public List<SeatAssignment> getAssignmentsForSlot(String slotId, Date date) {
        // Find all assignments for this slot and date
        // (Assuming a method exists or you can add one in the repository)
        return seatAssignmentRepository.findBySlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            slotId, date, date
        );
    }
} 