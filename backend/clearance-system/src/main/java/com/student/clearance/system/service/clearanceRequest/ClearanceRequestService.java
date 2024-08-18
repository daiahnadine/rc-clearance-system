package com.student.clearance.system.service.clearanceRequest;

import com.student.clearance.system.domain.clearanceRequest.ClearanceRequest;

import java.util.List;
import java.util.Optional;

public interface ClearanceRequestService {
    List<ClearanceRequest> getAllClearanceRequests();
    List<ClearanceRequest> getClearanceRequestsByStatus(ClearanceRequest.Status status);
    Optional<ClearanceRequest> getClearanceRequestById(Long id);
    ClearanceRequest addClearanceRequest(ClearanceRequest clearanceRequest);
    ClearanceRequest updateClearanceRequest(ClearanceRequest clearanceRequest);
    void deleteClearanceRequest(Long id);
    List<ClearanceRequest> getClearanceRequestsByStudentName(String name);
}
