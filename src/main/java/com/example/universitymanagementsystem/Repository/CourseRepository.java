package com.example.universitymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universitymanagementsystem.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Additional query methods can be defined here if needed
}

