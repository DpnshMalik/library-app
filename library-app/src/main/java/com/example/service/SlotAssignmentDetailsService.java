package com.example.service;

import com.example.dto.SlotAssignmentDetailsDTO;
import java.util.Date;
import java.util.List;

public interface SlotAssignmentDetailsService {
    List<SlotAssignmentDetailsDTO> getAssignmentsForSlotAndDate(String slotId, Date date);
}
