package com.example.universitymanagementsystem.Service;

import java.util.List;

import com.example.universitymanagementsystem.Utils.StudentDTO;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(Long id, StudentDTO studentDTO);

    void deleteStudent(Long id);
}

