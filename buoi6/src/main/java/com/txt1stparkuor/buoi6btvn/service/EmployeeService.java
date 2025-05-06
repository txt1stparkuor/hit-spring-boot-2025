package com.txt1stparkuor.buoi6btvn.service;

import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeSearchRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeCreationRequest request);

    EmployeeResponse getEmployeeById(Long id);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse updateEmployee(Long id, EmployeeUpdateRequest request);

    void deleteEmployee(Long id);

    List<EmployeeResponse> searchEmployees(String fullName, Long departmentId, Long positionId);

}