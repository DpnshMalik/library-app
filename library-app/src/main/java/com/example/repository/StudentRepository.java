package com.example.repository;

import com.example.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    // You can add custom query methods here if needed
}
