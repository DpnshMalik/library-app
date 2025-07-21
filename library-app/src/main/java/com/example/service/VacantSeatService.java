package com.example.service;

import com.example.dto.VacantSeatDTO;
import java.util.Date;
import java.util.List;

public interface VacantSeatService {
    List<VacantSeatDTO> getVacantSeats(String slotId, Date date);
}
