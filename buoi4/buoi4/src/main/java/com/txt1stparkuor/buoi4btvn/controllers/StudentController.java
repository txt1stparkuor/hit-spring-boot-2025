package com.txt1stparkuor.buoi4btvn.controllers;

import com.txt1stparkuor.buoi4btvn.dtos.request.StudentRequest;
import com.txt1stparkuor.buoi4btvn.dtos.response.ApiResponse;
import com.txt1stparkuor.buoi4btvn.entity.Student;
import com.txt1stparkuor.buoi4btvn.services.StudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentController {
    StudentService studentService;

    @GetMapping
    ApiResponse<List<Student>> getAllStudents() {
        return ApiResponse.<List<Student>>builder()
                .result(studentService.getAllStudents())
                .build();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody @Valid StudentRequest request) {
        Student createdStudent = studentService.createStudent(request);

        ApiResponse<Student> apiResponse = ApiResponse.<Student>builder()
                .result(createdStudent)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{id}")
    ApiResponse<Student> getStudentById(@PathVariable("id") Long id) {
        return ApiResponse.<Student>builder()
                .result(studentService.getStudentById(id))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<Student> updateStudent(@PathVariable("id") Long id, @RequestBody @Valid StudentRequest request) {
        return ApiResponse.<Student>builder()
                .result(studentService.updateStudent(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
