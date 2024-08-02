package com.student.clearance.system.service.adviser.impl;

import com.student.clearance.system.domain.adviser.Adviser;
import com.student.clearance.system.repository.adviser.AdviserRepository;
import com.student.clearance.system.service.adviser.AdviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviserServiceImpl implements AdviserService {

    private final AdviserRepository adviserRepository;

    @Autowired
    public AdviserServiceImpl(AdviserRepository adviserRepository) {
        this.adviserRepository = adviserRepository;
    }

    @Override
    public List<Adviser> getAllAdvisers() {
        return adviserRepository.findAll();
    }
}
