package com.school.management.controller;

import com.school.management.entity.Student;
import com.school.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setEmail(studentDetails.getEmail());
            student.setPhoneNumber(studentDetails.getPhoneNumber());
            student.setDateOfBirth(studentDetails.getDateOfBirth());
            student.setAddress(studentDetails.getAddress());
            student.setStudentId(studentDetails.getStudentId());
            return ResponseEntity.ok(studentService.saveStudent(student));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}