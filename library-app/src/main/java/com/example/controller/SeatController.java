package com.example.controller;

import com.example.model.Seat;
import com.example.repository.SeatRepository;
import com.example.dto.SeatDetailsDTO;
import com.example.service.SeatDetailsService;
import com.example.dto.VacantSeatDTO;
import com.example.service.VacantSeatService;
import com.example.dto.SeatStatusDTO;
import com.example.service.SeatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatDetailsService seatDetailsService;

    @Autowired
    private VacantSeatService vacantSeatService;

    @Autowired
    private SeatStatusService seatStatusService;

    // Create a new seat with validation
    @PostMapping
    public ResponseEntity<?> createSeat(@RequestBody Seat seat) {
        if (seat == null || seat.getSeatNumber() <= 0 || seat.getSeatType() == null || seat.getSeatType().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid seat data.");
        }
        // Optionally, check for duplicate seat number
        if (seatRepository.findBySeatNumber(seat.getSeatNumber()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Seat number already exists.");
        }
        Seat savedSeat = seatRepository.save(seat);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSeat);
    }

    // Get all seats
    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        return ResponseEntity.ok(seatRepository.findAll());
    }

    // Get seat details for a given seat and date with validation
    @GetMapping("/{seatId}/details")
    public ResponseEntity<?> getSeatDetails(@PathVariable String seatId,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.util.Date date) {
        if (seatId == null || seatId.isEmpty() || date == null) {
            return ResponseEntity.badRequest().body("Invalid or missing parameters.");
        }
        if (!seatRepository.existsById(seatId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seat not found.");
        }
        SeatDetailsDTO details = seatDetailsService.getSeatDetails(seatId, date);
        return ResponseEntity.ok(details);
    }

    // Get vacant seats for a given slot and date with validation
    @GetMapping("/vacant")
    public ResponseEntity<?> getVacantSeats(@RequestParam String slotId,
                                            @RequestParam @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) java.util.Date date) {
        if (slotId == null || slotId.isEmpty() || date == null) {
            return ResponseEntity.badRequest().body("Invalid or missing parameters.");
        }
        List<VacantSeatDTO> vacantSeats = vacantSeatService.getVacantSeats(slotId, date);
        return ResponseEntity.ok(vacantSeats);
    }

    // Get status of all seats for a given slot and date with validation
    @GetMapping("/status")
    public ResponseEntity<?> getAllSeatsStatus(@RequestParam String slotId,
                                               @RequestParam @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) java.util.Date date) {
        if (slotId == null || slotId.isEmpty() || date == null) {
            return ResponseEntity.badRequest().body("Invalid or missing parameters.");
        }
        List<SeatStatusDTO> statusList = seatStatusService.getAllSeatsStatus(slotId, date);
        return ResponseEntity.ok(statusList);
    }
} 