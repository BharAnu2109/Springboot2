package com.school.management.repository;

import com.school.management.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
    Optional<Teacher> findByEmployeeId(String employeeId);
    List<Teacher> findBySubject(String subject);
}