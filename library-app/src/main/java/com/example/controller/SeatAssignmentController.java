package com.example.controller;

import com.example.model.SeatAssignment;
import com.example.service.SeatAssignmentService;
import com.example.dto.AssignSeatRequestDTO;
import com.example.dto.SlotAssignmentDetailsDTO;
import com.example.service.SlotAssignmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import com.example.repository.SeatRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SlotRepository;


//rest controller is a combination of controller and response body
@RestController
@RequestMapping("/api/seat-assignments")
public class SeatAssignmentController {

    @Autowired
    private SeatAssignmentService seatAssignmentService;

    @Autowired
    private SlotAssignmentDetailsService slotAssignmentDetailsService;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SlotRepository slotRepository;

    // Assign a seat to a student for a slot and date range with validation and error handling
    @PostMapping("/assign")
    public ResponseEntity<?> assignSeat(@RequestBody AssignSeatRequestDTO request) {
        if (request == null ||
            request.getSeatId() == null || request.getSeatId().isEmpty() ||
            request.getStudentId() == null || request.getStudentId().isEmpty() ||
            request.getSlotId() == null || request.getSlotId().isEmpty() ||
            request.getStartDate() == null || request.getEndDate() == null ||
            request.getStartDate().after(request.getEndDate())) {
            return ResponseEntity.badRequest().body("Invalid or missing parameters.");
        }
        if (!seatRepository.existsById(request.getSeatId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found.");
        }
        if (!studentRepository.existsById(request.getStudentId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        if (!slotRepository.existsById(request.getSlotId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Slot not found.");
        }
        SeatAssignment assignment = seatAssignmentService.assignSeat(
            request.getSeatId(),
            request.getStudentId(),
            request.getSlotId(),
            request.getStartDate(),
            request.getEndDate()
        );
        return ResponseEntity.ok(assignment);
    }

    // Check if a seat is available for a slot and date range
    @GetMapping("/available")
    public boolean isSeatAvailable(@RequestParam String seatId,
                                   @RequestParam String slotId,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return seatAssignmentService.isSeatAvailable(seatId, slotId, startDate, endDate);
    }

    // Get assignments for a seat (optionally filtered by slot and date)
    @GetMapping("/by-seat")
    public List<SeatAssignment> getAssignmentsForSeat(@RequestParam String seatId,
                                                      @RequestParam(required = false) String slotId,
                                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return seatAssignmentService.getAssignmentsForSeat(seatId, slotId, date);
    }

    // Get assignments for a slot and date
    @GetMapping("/by-slot")
    public List<SeatAssignment> getAssignmentsForSlot(@RequestParam String slotId,
                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return seatAssignmentService.getAssignmentsForSlot(slotId, date);
    }

    // Get detailed assignments for a slot and date
    @GetMapping("/by-slot-details")
    public List<SlotAssignmentDetailsDTO> getAssignmentsForSlotAndDate(@RequestParam String slotId,
                                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.util.Date date) {
        return slotAssignmentDetailsService.getAssignmentsForSlotAndDate(slotId, date);
    }
} 