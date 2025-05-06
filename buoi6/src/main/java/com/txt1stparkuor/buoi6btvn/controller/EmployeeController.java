package com.txt1stparkuor.buoi6btvn.controller;

import com.txt1stparkuor.buoi6btvn.base.ResponseUtil;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeSearchRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.EmployeeResponse;
import com.txt1stparkuor.buoi6btvn.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping
    ResponseEntity<?> getAllEmployees() {
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        return ResponseUtil.success(employees);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseUtil.success(employee);
    }

    @PostMapping
    ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeCreationRequest request) {
        EmployeeResponse createdEmployee = employeeService.createEmployee(request);
        return ResponseUtil.success(HttpStatus.CREATED, createdEmployee);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeUpdateRequest request) {
        EmployeeResponse updatedEmployee = employeeService.updateEmployee(id, request);
        return ResponseUtil.success(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseUtil.success(HttpStatus.NO_CONTENT, null);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchEmployees(
            @Valid @ModelAttribute EmployeeSearchRequest searchRequest
    ) {
        List<EmployeeResponse> employees = employeeService.searchEmployees(
                searchRequest.getFullName(),
                searchRequest.getDepartmentId(),
                searchRequest.getPositionId()
        );
        return ResponseUtil.success(employees);
    }


}