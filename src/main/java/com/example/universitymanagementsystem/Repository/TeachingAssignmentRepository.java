package com.example.universitymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universitymanagementsystem.Entity.TeachingAssignment;

public interface TeachingAssignmentRepository extends JpaRepository<TeachingAssignment, Long> {
    // Additional query methods can be defined here if needed
}

