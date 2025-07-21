package com.example.repository;

import com.example.model.Slot;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlotRepository extends MongoRepository<Slot, String> {
	Optional<Slot> findByName(String name);
}