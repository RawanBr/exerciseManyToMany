package com.example.schoolsystem.Service;

import com.example.schoolsystem.Api.ApiException;
import com.example.schoolsystem.Model.Course;
import com.example.schoolsystem.Model.Student;
import com.example.schoolsystem.Repository.CourseRepository;
import com.example.schoolsystem.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getStudents () {
        if (studentRepository.findAll().isEmpty()) {
            throw new ApiException("No students found yet");
        }
        return studentRepository.findAll();
    }


    public void addStudent (Student student) {
        studentRepository.save(student);
    }

    public void updateStudent (Integer studentId, Student student) {
        Student oldStudent = studentRepository.findStudentById(studentId);
        if (oldStudent == null) {
            throw new ApiException("Student not found");
        }

        oldStudent.setAge(student.getAge());
        oldStudent.setName(student.getName());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);
    }


    public void deleteStudent (Integer studentId) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student);
    }

    public void changeMajor (Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new ApiException("Student not found");
        }

        student.setMajor(major);
        student.setCourses(null);
        studentRepository.save(student);
    }



    public void addCourse (Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(courseId);

        if (student == null || course == null) {
            throw new ApiException("Student or course not found");
        }

        student.getCourses().add(course);
        studentRepository.save(student);

    }
}
