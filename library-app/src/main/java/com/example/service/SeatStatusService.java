package com.example.service;

import com.example.dto.SeatStatusDTO;
import java.util.Date;
import java.util.List;

public interface SeatStatusService {
    List<SeatStatusDTO> getAllSeatsStatus(String slotId, Date date);
} 