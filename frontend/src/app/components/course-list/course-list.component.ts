import { Component, OnInit } from '@angular/core';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];
  newCourse: Course = { courseName: '', courseCode: '' };

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.courseService.getAllCourses().subscribe(
      data => this.courses = data,
      error => console.error('Error loading courses:', error)
    );
  }

  addCourse(): void {
    this.courseService.createCourse(this.newCourse).subscribe(
      data => {
        this.courses.push(data);
        this.resetForm();
      },
      error => console.error('Error adding course:', error)
    );
  }

  deleteCourse(id: number): void {
    if (confirm('Are you sure you want to delete this course?')) {
      this.courseService.deleteCourse(id).subscribe(
        () => {
          this.courses = this.courses.filter(c => c.id !== id);
        },
        error => console.error('Error deleting course:', error)
      );
    }
  }

  resetForm(): void {
    this.newCourse = { courseName: '', courseCode: '' };
  }
}