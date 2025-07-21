package com.example.repository;

import com.example.model.Seat;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeatRepository extends MongoRepository<Seat, String> {
	   Optional<Seat> findBySeatNumber(int seatNumber);
}