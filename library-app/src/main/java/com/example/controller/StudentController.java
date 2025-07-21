package com.example.controller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        if (student == null || student.getName() == null || student.getName().isEmpty() ||
            student.getJoiningDate() == null || student.getExpiryDate() == null ||
            student.getPaymentMode() == null || student.getPaymentMode().isEmpty() ||
            student.getIdentityProof() == null || student.getIdentityProof().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid student data.");
        }
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid or missing student ID.");
        }
        return studentRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found."));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        if (id == null || id.isEmpty() || updatedStudent == null) {
            return ResponseEntity.badRequest().body("Invalid or missing parameters.");
        }
        if (!studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        updatedStudent.setId(id);
        Student savedStudent = studentRepository.save(updatedStudent);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid or missing student ID.");
        }
        if (!studentRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
} 