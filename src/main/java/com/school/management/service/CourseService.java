package com.school.management.service;

import com.school.management.entity.Course;
import com.school.management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
    
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    
    public Optional<Course> findByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }
    
    public List<Course> findByTeacherId(Long teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }
}