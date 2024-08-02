package com.student.clearance.system.service.studentDiscipline.impl;


import com.student.clearance.system.domain.studentDiscipline.StudentDiscipline;
import com.student.clearance.system.repository.studentDiscipline.StudentDisciplineRepository;
import com.student.clearance.system.service.studentDiscipline.StudentDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDisciplineServiceImpl implements StudentDisciplineService {

    private final StudentDisciplineRepository studentDisciplineRepository;

    @Autowired
    public StudentDisciplineServiceImpl(StudentDisciplineRepository studentDisciplineRepository) {
        this.studentDisciplineRepository = studentDisciplineRepository;
    }

    @Override
    public List<StudentDiscipline> getAllStudentDisciplines() {
        return studentDisciplineRepository.findAll();
    }
}
