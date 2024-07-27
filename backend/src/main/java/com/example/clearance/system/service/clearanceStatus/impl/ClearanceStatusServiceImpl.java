package com.example.clearance.system.service.clearanceStatus.impl;

import com.example.clearance.system.domain.clearanceStatus.ClearanceStatus;
import com.example.clearance.system.repository.clearanceStatus.ClearanceStatusRepository;
import com.example.clearance.system.service.clearanceStatus.ClearanceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClearanceStatusServiceImpl implements ClearanceStatusService {

    private final ClearanceStatusRepository clearanceStatusRepository;

    @Autowired
    public ClearanceStatusServiceImpl(ClearanceStatusRepository clearanceStatusRepository) {
        this.clearanceStatusRepository = clearanceStatusRepository;
    }

    @Override
    public List<ClearanceStatus> getAllClearanceStatuses() {
        return clearanceStatusRepository.findAll();
    }

    @Override
    public Optional<ClearanceStatus> getClearanceStatusById(Long id) {
        return clearanceStatusRepository.findById(id);
    }

    @Override
    public ClearanceStatus addClearanceStatus(ClearanceStatus clearanceStatus) {
        return clearanceStatusRepository.save(clearanceStatus);
    }

    @Override
    public ClearanceStatus updateClearanceStatus(ClearanceStatus clearanceStatus) {
        return clearanceStatusRepository.save(clearanceStatus);
    }

    @Override
    public void deleteClearanceStatus(Long id) {
        clearanceStatusRepository.deleteById(id);
    }
}
