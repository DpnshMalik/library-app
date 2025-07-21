package com.example.service.impl;

import com.example.dto.SeatDetailsDTO;
import com.example.dto.SlotAssignmentDTO;
import com.example.model.Seat;
import com.example.model.SeatAssignment;
import com.example.model.Slot;
import com.example.model.Student;
import com.example.repository.SeatAssignmentRepository;
import com.example.repository.SeatRepository;
import com.example.repository.SlotRepository;
import com.example.repository.StudentRepository;
import com.example.service.SeatDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SeatDetailsServiceImpl implements SeatDetailsService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatAssignmentRepository seatAssignmentRepository;
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public SeatDetailsDTO getSeatDetails(String seatId, Date date) {
        Optional<Seat> seatOpt = seatRepository.findById(seatId);
        if (!seatOpt.isPresent()) {
            return null;
        }
        Seat seat = seatOpt.get();
        // Get all assignments for this seat on the given date
        List<SeatAssignment> assignments = seatAssignmentRepository.findBySeatIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            seatId, date, date
        );
        List<SlotAssignmentDTO> slotAssignments = new ArrayList<>();
        for (SeatAssignment assignment : assignments) {
            Optional<Slot> slotOpt = slotRepository.findById(assignment.getSlotId());
            Optional<Student> studentOpt = studentRepository.findById(assignment.getStudentId());
            String slotName = slotOpt.map(Slot::getName).orElse(assignment.getSlotId());
            String studentName = studentOpt.map(Student::getName).orElse(assignment.getStudentId());
            slotAssignments.add(new SlotAssignmentDTO(
                slotName,
                studentName,
                assignment.getSlotId(),
                assignment.getStudentId()
            ));
        }
        return new SeatDetailsDTO(seat.getSeatNumber(), seat.getSeatType(), slotAssignments);
    }
} 