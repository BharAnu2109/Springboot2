import { Component, OnInit } from '@angular/core';
import { Teacher } from '../../models/teacher.model';
import { TeacherService } from '../../services/teacher.service';

@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrls: ['./teacher-list.component.css']
})
export class TeacherListComponent implements OnInit {
  teachers: Teacher[] = [];
  newTeacher: Teacher = { firstName: '', lastName: '', email: '' };

  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.loadTeachers();
  }

  loadTeachers(): void {
    this.teacherService.getAllTeachers().subscribe(
      data => this.teachers = data,
      error => console.error('Error loading teachers:', error)
    );
  }

  addTeacher(): void {
    this.teacherService.createTeacher(this.newTeacher).subscribe(
      data => {
        this.teachers.push(data);
        this.resetForm();
      },
      error => console.error('Error adding teacher:', error)
    );
  }

  deleteTeacher(id: number): void {
    if (confirm('Are you sure you want to delete this teacher?')) {
      this.teacherService.deleteTeacher(id).subscribe(
        () => {
          this.teachers = this.teachers.filter(t => t.id !== id);
        },
        error => console.error('Error deleting teacher:', error)
      );
    }
  }

  resetForm(): void {
    this.newTeacher = { firstName: '', lastName: '', email: '' };
  }
}