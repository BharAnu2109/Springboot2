package com.school.management.controller;

import com.school.management.entity.Course;
import com.school.management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseService.saveCourse(course);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @Valid @RequestBody Course courseDetails) {
        Optional<Course> optionalCourse = courseService.getCourseById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setCourseName(courseDetails.getCourseName());
            course.setCourseCode(courseDetails.getCourseCode());
            course.setDescription(courseDetails.getDescription());
            course.setCredits(courseDetails.getCredits());
            course.setTeacher(courseDetails.getTeacher());
            return ResponseEntity.ok(courseService.saveCourse(course));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }
}