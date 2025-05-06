package com.txt1stparkuor.buoi6btvn.mapper;



import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.DepartmentUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.DepartmentResponse;
import com.txt1stparkuor.buoi6btvn.domain.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DepartmentMapper {
    Department toDepartment(DepartmentCreationRequest request);

    DepartmentResponse toDepartmentResponse(Department user);

    List<DepartmentResponse> toDepartmentResponseList(List<Department> users);

    void updateDepartment(@MappingTarget Department user, DepartmentUpdateRequest request);
}
