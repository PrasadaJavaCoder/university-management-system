package com.example.universitymanagementsystem.Service;

import java.util.List;

import com.example.universitymanagementsystem.Entity.Course;
import com.example.universitymanagementsystem.Payload.CourseDTO;

public interface CourseService {
    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id);

    CourseDTO createCourse(CourseDTO courseDTO);

    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

    boolean deleteCourse(Long id);
}
