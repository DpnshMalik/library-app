package com.example.service.impl;

import com.example.dto.SlotAssignmentDetailsDTO;
import com.example.model.Seat;
import com.example.model.SeatAssignment;
import com.example.model.Slot;
import com.example.model.Student;
import com.example.repository.SeatAssignmentRepository;
import com.example.repository.SeatRepository;
import com.example.repository.SlotRepository;
import com.example.repository.StudentRepository;
import com.example.service.SlotAssignmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SlotAssignmentDetailsServiceImpl implements SlotAssignmentDetailsService {
    @Autowired
    private SeatAssignmentRepository seatAssignmentRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<SlotAssignmentDetailsDTO> getAssignmentsForSlotAndDate(String slotId, Date date) {
        List<SeatAssignment> assignments = seatAssignmentRepository.findBySlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            slotId, date, date
        );
        List<SlotAssignmentDetailsDTO> detailsList = new ArrayList<>();
        for (SeatAssignment assignment : assignments) {
            Optional<Seat> seatOpt = seatRepository.findById(assignment.getSeatId());
            Optional<Student> studentOpt = studentRepository.findById(assignment.getStudentId());
            Optional<Slot> slotOpt = slotRepository.findById(assignment.getSlotId());
            int seatNumber = seatOpt.map(Seat::getSeatNumber).orElse(-1);
            String studentName = studentOpt.map(Student::getName).orElse(assignment.getStudentId());
            String slotName = slotOpt.map(Slot::getName).orElse(assignment.getSlotId());
            detailsList.add(new SlotAssignmentDetailsDTO(
                assignment.getSeatId(),
                seatNumber,
                assignment.getStudentId(),
                studentName,
                assignment.getSlotId(),
                slotName
            ));
        }
        return detailsList;
    }
} 