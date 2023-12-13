package com.example.universitymanagementsystem.Service.ServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.universitymanagementsystem.Entity.Student;
import com.example.universitymanagementsystem.Exception.ResourceNotFoundException;
import com.example.universitymanagementsystem.Repository.StudentRepository;
import com.example.universitymanagementsystem.Service.StudentService;
import com.example.universitymanagementsystem.Utils.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapperUtil;


    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapperUtil) {
        this.studentRepository = studentRepository;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapperUtil.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        return modelMapperUtil.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = modelMapperUtil.map(studentDTO, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapperUtil.map(savedStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        modelMapperUtil.map(studentDTO, existingStudent);

        Student updatedStudent = studentRepository.save(existingStudent);
        return modelMapperUtil.map(updatedStudent, StudentDTO.class);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}




