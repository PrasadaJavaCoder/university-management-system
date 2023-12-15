package com.example.universitymanagementsystem.Service.ServiceImpl;

import com.example.universitymanagementsystem.Entity.Course;
import com.example.universitymanagementsystem.Exception.ResourceNotFoundException;
import com.example.universitymanagementsystem.Payload.CourseDTO;
import com.example.universitymanagementsystem.Repository.CourseRepository;
import com.example.universitymanagementsystem.Service.CourseService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> collect = courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseDTO.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        return modelMapper.map(courseRepository.save(modelMapper.map(courseDTO, Course.class)), CourseDTO.class);
    }

    @Override
    @Transactional
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        modelMapper.map(courseDTO, existingCourse);

        return modelMapper.map(existingCourse, CourseDTO.class);
    }

    @Override
    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        } else {
            throw new ResourceNotFoundException("Course", "id", id);
        }
    }
}
