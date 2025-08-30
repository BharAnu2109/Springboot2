package com.school.management.service;

import com.school.management.entity.Teacher;
import com.school.management.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }
    
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
    
    public Optional<Teacher> findByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }
    
    public List<Teacher> findBySubject(String subject) {
        return teacherRepository.findBySubject(subject);
    }
}