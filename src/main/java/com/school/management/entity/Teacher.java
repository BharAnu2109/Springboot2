package com.school.management.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "subject")
    private String subject;
    
    @Column(name = "hire_date")
    private LocalDate hireDate;
    
    @Column(name = "employee_id", unique = true)
    private String employeeId;
    
    @Column(name = "department")
    private String department;
    
    // Constructors
    public Teacher() {}
    
    public Teacher(String firstName, String lastName, String email, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subject = subject;
        this.hireDate = LocalDate.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public LocalDate getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}