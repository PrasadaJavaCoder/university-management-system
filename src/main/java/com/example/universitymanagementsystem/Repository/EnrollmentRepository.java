package com.example.universitymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universitymanagementsystem.Entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Additional query methods can be defined here if needed
}
