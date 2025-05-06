package com.txt1stparkuor.buoi6btvn.mapper;

import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.EmployeeResponse;
import com.txt1stparkuor.buoi6btvn.domain.entity.Employee;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EmployeeMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "position", ignore = true)
    Employee toEmployee(EmployeeCreationRequest request);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "position", ignore = true)
    void updateEmployee(@MappingTarget Employee employee, EmployeeUpdateRequest request);

    EmployeeResponse toEmployeeResponse(Employee employee);

    List<EmployeeResponse> toEmployeeResponseList(List<Employee> employees);
}