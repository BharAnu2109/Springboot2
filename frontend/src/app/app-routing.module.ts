import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { StudentListComponent } from './components/student-list/student-list.component';
import { TeacherListComponent } from './components/teacher-list/teacher-list.component';
import { CourseListComponent } from './components/course-list/course-list.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'students', component: StudentListComponent },
  { path: 'teachers', component: TeacherListComponent },
  { path: 'courses', component: CourseListComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }