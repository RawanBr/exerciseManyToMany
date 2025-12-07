package com.example.schoolsystem.Controller;

import com.example.schoolsystem.Api.ApiResponse;
import com.example.schoolsystem.Model.Course;
import com.example.schoolsystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService  courseService;


    @GetMapping("/get")
    public ResponseEntity<?> getCourses () {
        return ResponseEntity.status(200).body(courseService.getCourses());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addCourse (@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }


    @PutMapping("update/{courseId}")
    public ResponseEntity<?> updateCourse (@PathVariable Integer courseId, @RequestBody @Valid Course course) {
        courseService.updateCourse(courseId, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }


    @DeleteMapping("delete/{courseId}")
    public ResponseEntity<?>  deleteCourse (@PathVariable Integer courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }


    @GetMapping("/get-teacher-by-courseId/{courseId}")
    public ResponseEntity<?> getTeacherByCourseId (@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getTeacherByCourseId(courseId));

    }


    @GetMapping("/get-student-by-courseId/{courseId}")
    public ResponseEntity<?> getStudentByCourseId (@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(courseService.getStudentByCourseId(courseId));
    }


}
