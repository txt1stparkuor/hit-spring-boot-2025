package com.txt1stparkuor.buoi6btvn.service;

import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> getAllDepartments();
    DepartmentResponse getDepartmentById(Long id);
    DepartmentResponse createDepartment(DepartmentCreationRequest request);
    DepartmentResponse updateDepartment(Long id, DepartmentUpdateRequest request);
    void deleteDepartment(Long id);
}
