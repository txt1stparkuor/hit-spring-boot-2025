package com.txt1stparkuor.buoi6btvn.controller;

import com.txt1stparkuor.buoi6btvn.base.ResponseUtil;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.DepartmentResponse;
import com.txt1stparkuor.buoi6btvn.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/departments")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DepartmentController {

    DepartmentService departmentService;

    @GetMapping
    ResponseEntity<?> getAllDepartments() {
        List<DepartmentResponse> departments = departmentService.getAllDepartments();
        return ResponseUtil.success(departments);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        DepartmentResponse department = departmentService.getDepartmentById(id);
        return ResponseUtil.success(department);
    }

    @PostMapping
    ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentCreationRequest request) {
        DepartmentResponse createdDepartment = departmentService.createDepartment(request);
        return ResponseUtil.success(HttpStatus.CREATED, createdDepartment);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateDepartment(
            @PathVariable Long id, @Valid @RequestBody DepartmentUpdateRequest request
    ) {
        DepartmentResponse updatedDepartment = departmentService.updateDepartment(id, request);
        return ResponseUtil.success(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}