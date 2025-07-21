package com.example.service.impl;

import com.example.dto.VacantSeatDTO;
import com.example.model.Seat;
import com.example.model.SeatAssignment;
import com.example.repository.SeatAssignmentRepository;
import com.example.repository.SeatRepository;
import com.example.service.VacantSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VacantSeatServiceImpl implements VacantSeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatAssignmentRepository seatAssignmentRepository;

    @Override
    public List<VacantSeatDTO> getVacantSeats(String slotId, Date date) {
        List<Seat> allSeats = seatRepository.findAll();
        List<SeatAssignment> assignments = seatAssignmentRepository.findBySlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            slotId, date, date
        );
        Set<String> assignedSeatIds = new HashSet<>();
        for (SeatAssignment assignment : assignments) {
            assignedSeatIds.add(assignment.getSeatId());
        }
        List<VacantSeatDTO> vacantSeats = new ArrayList<>();
        for (Seat seat : allSeats) {
            if (!assignedSeatIds.contains(seat.getId())) {
                vacantSeats.add(new VacantSeatDTO(seat.getId(), seat.getSeatNumber(), seat.getSeatType()));
            }
        }
        return vacantSeats;
    }
}
