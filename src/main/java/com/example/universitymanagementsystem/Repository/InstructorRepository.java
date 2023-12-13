package com.example.universitymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universitymanagementsystem.Entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // Additional query methods can be defined here if needed
}

