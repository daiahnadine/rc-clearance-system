package com.example.clearance.system.service.clearance;

import com.example.clearance.system.domain.clearance.Clearance;

import java.util.List;
import java.util.Optional;

public interface ClearanceService {
    List<Clearance> getAllClearances();
    Optional<Clearance> getClearanceById(Long id);
    Clearance addClearance(Clearance clearance);
    Clearance updateClearance(Clearance clearance);
    void deleteClearance(Long id);
}
