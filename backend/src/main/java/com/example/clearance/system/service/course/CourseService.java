package com.example.clearance.system.service.course;

import com.example.clearance.system.domain.course.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course addCourse(Course course);
    Course updateCourse(Course course);
}
