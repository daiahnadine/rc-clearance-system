package com.student.clearance.system.service.clearance.impl;

import com.student.clearance.system.domain.clearance.Clearance;
import com.student.clearance.system.domain.student.Student;
import com.student.clearance.system.repository.clearance.ClearanceRepository;
import com.student.clearance.system.repository.student.StudentRepository;
import com.student.clearance.system.service.clearance.ClearanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClearanceServiceImpl implements ClearanceService {

    private final ClearanceRepository clearanceRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public ClearanceServiceImpl(ClearanceRepository clearanceRepository, StudentRepository studentRepository) {
        this.clearanceRepository = clearanceRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Clearance> getAllClearances() {
        return clearanceRepository.findAll();
    }

    @Override
    public Optional<Clearance> getClearanceById(Long id) {
        return clearanceRepository.findById(id);
    }

    @Transactional
    @Override
    public Clearance addClearance(Clearance clearance, String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new RuntimeException("Student not found with studentNumber: " + studentNumber));

        clearance.setStudent(student);

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
