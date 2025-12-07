package com.example.schoolsystem.Controller;

import com.example.schoolsystem.Api.ApiResponse;
import com.example.schoolsystem.Model.Teacher;
import com.example.schoolsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity<?> getTeachers () {
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addTeacher (@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }


    @PutMapping("/update/{teacherId}")
    public ResponseEntity<?> updateTeacher (@PathVariable Integer teacherId, @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(teacherId, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully"));
    }


    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteTeacher (@PathVariable Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully"));
    }


    @GetMapping("/get-by-id/{teacherId}")
    public ResponseEntity<?> getTeacherById (@PathVariable Integer teacherId) {
        return ResponseEntity.status(200).body(teacherService.getTeacherById(teacherId));
    }


    @PutMapping("/assign-course/{teacherId}/{courseId}")
    public ResponseEntity<?> assignCourseToTeacher (@PathVariable Integer teacherId, @PathVariable Integer courseId) {
     teacherService.assignCourseToTeacher(teacherId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Course assigned to the teacher successfully"));

    }

}
