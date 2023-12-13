package com.example.universitymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.universitymanagementsystem.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Additional query methods can be defined here if needed
}

