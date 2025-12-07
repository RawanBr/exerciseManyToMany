package com.example.schoolsystem.Service;

import com.example.schoolsystem.Api.ApiException;
import com.example.schoolsystem.DTO.TeacherDTO;
import com.example.schoolsystem.Model.Course;
import com.example.schoolsystem.Model.Student;
import com.example.schoolsystem.Model.Teacher;
import com.example.schoolsystem.Repository.CourseRepository;
import com.example.schoolsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getCourses () {
        if (courseRepository.findAll().isEmpty()) {
            throw new ApiException("No courses yet");
        }
        return courseRepository.findAll();
    }

    public void addCourse (Course course) {
        courseRepository.save(course);
    }


    public void updateCourse (Integer courseId, Course course) {
        Course oldCourse = courseRepository.findCourseById(courseId);
        if (oldCourse == null) {
            throw new ApiException("Course not found");
        }

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }


    public void deleteCourse (Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }


    public TeacherDTO getTeacherByCourseId (Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        Teacher teacher = teacherRepository.findTeacherById(course.getTeacher().getId());
        TeacherDTO teacherDTO = new TeacherDTO(teacher.getName());

        return teacherDTO;
    }


    public Set<Student> getStudentByCourseId (Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        return course.getStudents();
    }


}
