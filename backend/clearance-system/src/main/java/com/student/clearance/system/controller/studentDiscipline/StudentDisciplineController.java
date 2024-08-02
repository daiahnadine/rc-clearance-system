package com.student.clearance.system.controller.studentDiscipline;

import com.student.clearance.system.domain.studentDiscipline.StudentDiscipline;
import com.student.clearance.system.service.studentDiscipline.StudentDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Prefect")
public class StudentDisciplineController {

    private final StudentDisciplineService studentDisciplineService;

    @Autowired
    public StudentDisciplineController(StudentDisciplineService studentDisciplineService) {
        this.studentDisciplineService = studentDisciplineService;
    }

    @GetMapping("/Prefects")
    public ResponseEntity<List<StudentDiscipline>> getAllStudentDisciplines() {
        return new ResponseEntity<>(studentDisciplineService.getAllStudentDisciplines(), HttpStatus.OK);
    }
}
