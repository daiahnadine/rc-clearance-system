package com.example.clearance.system.controller.student;

import com.example.clearance.system.domain.student.Student;
import com.example.clearance.system.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setMiddleName(studentDetails.getMiddleName());
            student.setBirthdate(studentDetails.getBirthdate());
            student.setBirthplace(studentDetails.getBirthplace());
            student.setSex(studentDetails.getSex());
            student.setCivilStatus(studentDetails.getCivilStatus());
            student.setCitizenship(studentDetails.getCitizenship());
            student.setReligion(studentDetails.getReligion());
            student.setEmail(studentDetails.getEmail());
            student.setAddress(studentDetails.getAddress());
            student.setContactNumber(studentDetails.getContactNumber());
            student.setYearLevel(studentDetails.getYearLevel());
            student.setCourse(studentDetails.getCourse());
            student.setUser(studentDetails.getUser());
            student.setClearances(studentDetails.getClearances());

            Student updatedStudent = studentService.updateStudent(student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
