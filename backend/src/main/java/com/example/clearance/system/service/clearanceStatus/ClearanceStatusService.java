package com.example.clearance.system.service.clearanceStatus;

import com.example.clearance.system.domain.clearanceStatus.ClearanceStatus;

import java.util.List;
import java.util.Optional;

public interface ClearanceStatusService {
    List<ClearanceStatus> getAllClearanceStatuses();
    Optional<ClearanceStatus> getClearanceStatusById(Long id);
    ClearanceStatus addClearanceStatus(ClearanceStatus clearanceStatus);
    ClearanceStatus updateClearanceStatus(ClearanceStatus clearanceStatus);
    void deleteClearanceStatus(Long id);
}
