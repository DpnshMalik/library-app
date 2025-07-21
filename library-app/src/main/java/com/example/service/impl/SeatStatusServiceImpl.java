package com.example.service.impl;

import com.example.dto.SeatStatusDTO;
import com.example.model.Seat;
import com.example.model.SeatAssignment;
import com.example.model.Student;
import com.example.repository.SeatAssignmentRepository;
import com.example.repository.SeatRepository;
import com.example.repository.StudentRepository;
import com.example.service.SeatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeatStatusServiceImpl implements SeatStatusService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatAssignmentRepository seatAssignmentRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    	public List<SeatStatusDTO> getAllSeatsStatus(String slotId, Date date) {
    	    List<Seat> allSeats = seatRepository.findAll();

    	    List<SeatAssignment> assignments = seatAssignmentRepository
    	        .findBySlotIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(slotId, date, date);

    	    Map<String, SeatAssignment> seatIdToAssignment = assignments.stream()
    	        .collect(Collectors.toMap(SeatAssignment::getSeatId, a -> a));

    	    return allSeats.stream()
    	        .map(seat -> {
    	            SeatAssignment assignment = seatIdToAssignment.get(seat.getId());

    	            if (assignment != null) {
    	                String studentName = studentRepository.findById(assignment.getStudentId())
    	                        .map(Student::getName)
    	                        .orElse(assignment.getStudentId());

    	                return new SeatStatusDTO(
    	                        seat.getId(),
    	                        seat.getSeatNumber(),
    	                        seat.getSeatType(),
    	                        "occupied",
    	                        assignment.getStudentId(),
    	                        studentName
    	                );
    	            } else {
    	                return new SeatStatusDTO(
    	                        seat.getId(),
    	                        seat.getSeatNumber(),
    	                        seat.getSeatType(),
    	                        "vacant",
    	                        null,
    	                        null
    	                );
    	            }
    	        })
    	        .collect(Collectors.toList());
    	}
    }
    
    
