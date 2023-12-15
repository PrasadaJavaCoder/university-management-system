package com.example.universitymanagementsystem.Controllers;

import com.example.universitymanagementsystem.Entity.Course;
import com.example.universitymanagementsystem.Payload.CourseDTO;
import com.example.universitymanagementsystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> collect = courseService.getAllCourses();
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        return new ResponseEntity<>(courseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO createdCourseDTO = courseService.createCourse(courseDTO);
        return new ResponseEntity<>(createdCourseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        CourseDTO updatedCourseDTO = courseService.updateCourse(id, courseDTO);
        return new ResponseEntity<>(updatedCourseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            return new ResponseEntity<>("Course with ID " + id + " has been deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
