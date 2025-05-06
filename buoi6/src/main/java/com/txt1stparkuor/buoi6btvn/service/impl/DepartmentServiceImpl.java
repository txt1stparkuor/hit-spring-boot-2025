package com.txt1stparkuor.buoi6btvn.service.impl;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.DepartmentResponse;
import com.txt1stparkuor.buoi6btvn.domain.entity.Department;
import com.txt1stparkuor.buoi6btvn.exception.DuplicateResourceException;
import com.txt1stparkuor.buoi6btvn.exception.NotFoundException;
import com.txt1stparkuor.buoi6btvn.mapper.DepartmentMapper;
import com.txt1stparkuor.buoi6btvn.repository.DepartmentRepository;
import com.txt1stparkuor.buoi6btvn.service.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper;
    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentMapper.toDepartmentResponseList(departmentRepository.findAll());
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Department.ERR_NOT_FOUND_ID,
                        new String[]{String.valueOf(id)}));
        return departmentMapper.toDepartmentResponse(department);
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentCreationRequest request) {
        if (departmentRepository.existsByName(request.getName())) {
            throw new DuplicateResourceException(ErrorMessage.DUPLICATE_RESOURCE,
                    new String[]{"Department n  ame: " + request.getName()} );
        }
        Department department = departmentMapper.toDepartment(request);
        return departmentMapper.toDepartmentResponse(departmentRepository.save(department));
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentUpdateRequest request) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(ErrorMessage.Department.ERR_NOT_FOUND_ID,
                                new String[]{String.valueOf(id)}));

        if (!request.getName().equalsIgnoreCase(existingDepartment.getName())) {
            if (departmentRepository.existsByNameAndIdNot(request.getName(),id)) {
                throw new DuplicateResourceException(ErrorMessage.DUPLICATE_RESOURCE,
                        new String[]{"Department name: " + request.getName()} );
            }
        }
        departmentMapper.updateDepartment(existingDepartment, request);
        return departmentMapper.toDepartmentResponse(departmentRepository.save(existingDepartment));
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
