package com.example.clearance.system.service.clearanceHistory;

import com.example.clearance.system.domain.clearanceHistory.ClearanceHistory;

import java.util.List;
import java.util.Optional;

public interface ClearanceHistoryService {
    List<ClearanceHistory> getAllClearanceHistories();
    Optional<ClearanceHistory> getClearanceHistoryById(Long id);
    ClearanceHistory addClearanceHistory(ClearanceHistory clearanceHistory);
    ClearanceHistory updateClearanceHistory(ClearanceHistory clearanceHistory);
    void deleteClearanceHistory(Long id);
}
