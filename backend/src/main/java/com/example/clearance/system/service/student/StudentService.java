package com.example.clearance.system.service.student;

import com.example.clearance.system.domain.student.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
}
