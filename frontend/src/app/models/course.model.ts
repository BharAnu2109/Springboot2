import { Teacher } from './teacher.model';

export interface Course {
  id?: number;
  courseName: string;
  courseCode: string;
  description?: string;
  credits?: number;
  teacher?: Teacher;
}