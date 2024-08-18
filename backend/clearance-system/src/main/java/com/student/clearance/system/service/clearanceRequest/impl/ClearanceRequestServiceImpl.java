package com.student.clearance.system.service.clearanceRequest.impl;

import com.student.clearance.system.domain.clearanceRequest.ClearanceRequest;
import com.student.clearance.system.repository.clearanceRequest.ClearanceRequestRepository;
import com.student.clearance.system.service.clearanceRequest.ClearanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClearanceRequestServiceImpl implements ClearanceRequestService {

    private final ClearanceRequestRepository clearanceRequestRepository;

    @Autowired
    public ClearanceRequestServiceImpl(ClearanceRequestRepository clearanceRequestRepository) {
        this.clearanceRequestRepository = clearanceRequestRepository;
    }

    @Override
    public List<ClearanceRequest> getAllClearanceRequests() {
        return clearanceRequestRepository.findAll();
    }

    @Override
    public List<ClearanceRequest> getClearanceRequestsByStatus(ClearanceRequest.Status status) {
        return null;
    }

    @Override
    public Optional<ClearanceRequest> getClearanceRequestById(Long id) {
        return clearanceRequestRepository.findById(id);
    }

    @Override
    public ClearanceRequest addClearanceRequest(ClearanceRequest clearanceRequest) {
        return clearanceRequestRepository.save(clearanceRequest);
    }

    @Override
    public ClearanceRequest updateClearanceRequest(ClearanceRequest clearanceRequest) {
        return clearanceRequestRepository.save(clearanceRequest);
    }

    @Override
    public void deleteClearanceRequest(Long id) {
        clearanceRequestRepository.deleteById(id);
    }

    @Override
    public List<ClearanceRequest> getClearanceRequestsByStudentName(String name) {
        return clearanceRequestRepository.findByStudent_FirstNameContainingIgnoreCaseOrStudent_MiddleNameContainingIgnoreCaseOrStudent_LastNameContainingIgnoreCase(name, name, name);
    }
}
