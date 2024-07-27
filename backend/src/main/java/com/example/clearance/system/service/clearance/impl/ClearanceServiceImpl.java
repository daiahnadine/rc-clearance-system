package com.example.clearance.system.service.clearance.impl;

import com.example.clearance.system.domain.clearance.Clearance;
import com.example.clearance.system.repository.clearance.ClearanceRepository;
import com.example.clearance.system.service.clearance.ClearanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClearanceServiceImpl implements ClearanceService {

    private final ClearanceRepository clearanceRepository;

    @Autowired
    public ClearanceServiceImpl(ClearanceRepository clearanceRepository) {
        this.clearanceRepository = clearanceRepository;
    }

    @Override
    public List<Clearance> getAllClearances() {
        return clearanceRepository.findAll();
    }

    @Override
    public Optional<Clearance> getClearanceById(Long id) {
        return clearanceRepository.findById(id);
    }

    @Override
    public Clearance addClearance(Clearance clearance) {
        return clearanceRepository.save(clearance);
    }

    @Override
    public Clearance updateClearance(Clearance clearance) {
        return clearanceRepository.save(clearance);
    }

    @Override
    public void deleteClearance(Long id) {
        clearanceRepository.deleteById(id);
    }
}
