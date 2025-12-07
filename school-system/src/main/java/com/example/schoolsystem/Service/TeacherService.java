package com.example.schoolsystem.Service;

import com.example.schoolsystem.Api.ApiException;
import com.example.schoolsystem.Model.Course;
import com.example.schoolsystem.Model.Teacher;
import com.example.schoolsystem.Repository.CourseRepository;
import com.example.schoolsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public List<Teacher> getTeachers () {
        if (teacherRepository.findAll().isEmpty()) {
            throw new ApiException("No teacher found");
        }
        return teacherRepository.findAll();
    }


    public void addTeacher (Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher (Integer teacherId, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(teacherId);
        if (oldTeacher == null) {
            throw new ApiException("Teacher not found");
        }

        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);
    }


    public void deleteTeacher (Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById (Integer teacherId) {
        if (teacherRepository.findTeacherById(teacherId) == null) {
            throw new ApiException("Teacher not found");
        }
        return teacherRepository.findTeacherById(teacherId);
    }


    public void assignCourseToTeacher (Integer teacherId, Integer courseId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);

        if (teacher == null || course  == null) {
            throw new ApiException("Teacher or course not found");
        }

        teacher.getCourses().add(course);
        course.setTeacher(teacher);
        teacherRepository.save(teacher);
    }
}
