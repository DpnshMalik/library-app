package com.example.controller;

import com.example.model.Slot;
import com.example.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {
    @Autowired
    private SlotRepository slotRepository;

    // Create a new slot with validation
    @PostMapping
    public ResponseEntity<?> createSlot(@RequestBody Slot slot) {
        if (slot == null || slot.getName() == null || slot.getName().isEmpty() ||
            slot.getStartTime() == null || slot.getStartTime().isEmpty() ||
            slot.getEndTime() == null || slot.getEndTime().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid slot data.");
        }
        // Optionally, check for duplicate slot name
        if (slotRepository.findByName(slot.getName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Slot name already exists.");
        }
        Slot savedSlot = slotRepository.save(slot);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSlot);
    }

    // Get all slots
    @GetMapping
    public ResponseEntity<List<Slot>> getAllSlots() {
        return ResponseEntity.ok(slotRepository.findAll());
    }
} 