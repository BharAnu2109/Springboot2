import { Component, OnInit } from '@angular/core';
import { Student } from '../../models/student.model';
import { StudentService } from '../../services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];
  newStudent: Student = { firstName: '', lastName: '', email: '' };
  isEditing = false;
  editingStudent: Student | null = null;

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.studentService.getAllStudents().subscribe(
      data => this.students = data,
      error => console.error('Error loading students:', error)
    );
  }

  addStudent(): void {
    this.studentService.createStudent(this.newStudent).subscribe(
      data => {
        this.students.push(data);
        this.resetForm();
      },
      error => console.error('Error adding student:', error)
    );
  }

  editStudent(student: Student): void {
    this.isEditing = true;
    this.editingStudent = { ...student };
  }

  updateStudent(): void {
    if (this.editingStudent && this.editingStudent.id) {
      this.studentService.updateStudent(this.editingStudent.id, this.editingStudent).subscribe(
        data => {
          const index = this.students.findIndex(s => s.id === data.id);
          if (index !== -1) {
            this.students[index] = data;
          }
          this.cancelEdit();
        },
        error => console.error('Error updating student:', error)
      );
    }
  }

  deleteStudent(id: number): void {
    if (confirm('Are you sure you want to delete this student?')) {
      this.studentService.deleteStudent(id).subscribe(
        () => {
          this.students = this.students.filter(s => s.id !== id);
        },
        error => console.error('Error deleting student:', error)
      );
    }
  }

  cancelEdit(): void {
    this.isEditing = false;
    this.editingStudent = null;
  }

  resetForm(): void {
    this.newStudent = { firstName: '', lastName: '', email: '' };
  }
}