package com.example.schoolsystem.Controller;

import com.example.schoolsystem.Api.ApiResponse;
import com.example.schoolsystem.Model.Student;
import com.example.schoolsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity<?> getStudents () {
        return ResponseEntity.status(200).body(studentService.getStudents());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addStudent (@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }


    @PutMapping("/update/{studentId}")
    public ResponseEntity<?> updateStudent (@PathVariable Integer studentId, @RequestBody @Valid Student student) {
        studentService.updateStudent(studentId, student);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
    }


    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
    }


    @PutMapping("/change-major/{studentId}/{major}")
    public ResponseEntity<?> changeMajor (@PathVariable Integer studentId, @PathVariable String major) {
        studentService.changeMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("Major changed successfully successfully"));
    }


    @PutMapping("/add-course/{studentId}/{courseId}")
    public ResponseEntity<?> addCourse (@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.addCourse(studentId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }
}
