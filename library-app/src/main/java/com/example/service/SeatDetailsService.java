package com.example.service;

import com.example.dto.SeatDetailsDTO;
import java.util.Date;

public interface SeatDetailsService {
    SeatDetailsDTO getSeatDetails(String seatId, Date date);
} 