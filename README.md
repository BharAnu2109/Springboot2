# School Management System

A complete school management system built with Spring Boot backend and Angular frontend.

## Features

### Backend (Spring Boot)
- RESTful APIs for managing students, teachers, and courses
- JPA/Hibernate for database operations
- H2 in-memory database for development
- CORS configuration for Angular integration
- Maven build system

### Frontend (Angular)
- Modern, responsive UI with Bootstrap
- Components for managing students, teachers, and courses
- HTTP client services for API communication
- Form validation and error handling
- Routing between different sections

## Tech Stack

**Backend:**
- Java 11
- Spring Boot 2.7.14
- Spring Data JPA
- H2 Database
- Maven

**Frontend:**
- Angular 15
- TypeScript
- Bootstrap 5
- RxJS

## Getting Started

### Prerequisites
- Java 11 or higher
- Node.js 14 or higher
- npm or yarn

### Running the Application

1. **Start the Spring Boot Backend**
   ```bash
   mvn spring-boot:run
   ```
   The backend will start on `http://localhost:8080`

2. **Start the Angular Frontend**
   ```bash
   cd frontend
   npm install
   npm start
   ```
   The frontend will start on `http://localhost:4200`

### Database Access
- H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:schooldb`
- Username: `sa`
- Password: (empty)

## API Endpoints

### Students
- GET `/api/students` - Get all students
- GET `/api/students/{id}` - Get student by ID
- POST `/api/students` - Create new student
- PUT `/api/students/{id}` - Update student
- DELETE `/api/students/{id}` - Delete student

### Teachers
- GET `/api/teachers` - Get all teachers
- GET `/api/teachers/{id}` - Get teacher by ID
- POST `/api/teachers` - Create new teacher
- PUT `/api/teachers/{id}` - Update teacher
- DELETE `/api/teachers/{id}` - Delete teacher

### Courses
- GET `/api/courses` - Get all courses
- GET `/api/courses/{id}` - Get course by ID
- POST `/api/courses` - Create new course
- PUT `/api/courses/{id}` - Update course
- DELETE `/api/courses/{id}` - Delete course

## Screenshots

### Home Page
![Home Page](https://github.com/user-attachments/assets/75b31d52-5e00-46f9-95c1-74f3a36ad389)

### Students Management
![Students Page](https://github.com/user-attachments/assets/1a9ce094-ea1a-4b38-b0ef-e219270729c0)

## Project Structure

```
├── src/main/java/com/school/management/
│   ├── SchoolManagementApplication.java
│   ├── controller/
│   │   ├── StudentController.java
│   │   ├── TeacherController.java
│   │   └── CourseController.java
│   ├── entity/
│   │   ├── Student.java
│   │   ├── Teacher.java
│   │   └── Course.java
│   ├── repository/
│   │   ├── StudentRepository.java
│   │   ├── TeacherRepository.java
│   │   └── CourseRepository.java
│   └── service/
│       ├── StudentService.java
│       ├── TeacherService.java
│       └── CourseService.java
├── frontend/
│   └── src/app/
│       ├── components/
│       ├── models/
│       └── services/
└── pom.xml
```

## License

This project is licensed under the MIT License.