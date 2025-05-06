package com.txt1stparkuor.buoi6btvn.service.impl;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.EmployeeUpdateRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.EmployeeResponse;
import com.txt1stparkuor.buoi6btvn.domain.entity.Department;
import com.txt1stparkuor.buoi6btvn.domain.entity.Employee;
import com.txt1stparkuor.buoi6btvn.domain.entity.Position;
import com.txt1stparkuor.buoi6btvn.domain.entity.User;
import com.txt1stparkuor.buoi6btvn.exception.NotFoundException;
import com.txt1stparkuor.buoi6btvn.mapper.EmployeeMapper;
import com.txt1stparkuor.buoi6btvn.repository.DepartmentRepository;
import com.txt1stparkuor.buoi6btvn.repository.EmployeeRepository;
import com.txt1stparkuor.buoi6btvn.repository.PositionRepository;
import com.txt1stparkuor.buoi6btvn.repository.UserRepository;
import com.txt1stparkuor.buoi6btvn.service.EmployeeService;

import jakarta.persistence.criteria.Join;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import jakarta.persistence.criteria.JoinType;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    UserRepository userRepository;
    DepartmentRepository departmentRepository;
    PositionRepository positionRepository;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toEmployeeResponseList(employees);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = findEmployeeByIdOrThrow(id);
        return employeeMapper.toEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeCreationRequest request) {
        User user = findUserByIdOrThrow(request.getUserId());
        Department department = findDepartmentByIdOrThrow(request.getDepartmentId());
        Position position = findPositionByIdOrThrow(request.getPositionId());

        Employee employee = employeeMapper.toEmployee(request);
        employee.setUser(user);
        employee.setDepartment(department);
        employee.setPosition(position);

        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponse(savedEmployee);
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeUpdateRequest request) {
        Employee existingEmployee = findEmployeeByIdOrThrow(id);

        if (!Objects.equals(request.getUserId(), existingEmployee.getUser().getId())) {
            User user = findUserByIdOrThrow(request.getUserId());
            existingEmployee.setUser(user);
        }

        if (!Objects.equals(request.getDepartmentId(), existingEmployee.getDepartment().getId())) {
            Department department = findDepartmentByIdOrThrow(request.getDepartmentId());
            existingEmployee.setDepartment(department);
        }

        if (!Objects.equals(request.getPositionId(), existingEmployee.getPosition().getId())) {
            Position position = findPositionByIdOrThrow(request.getPositionId());
            existingEmployee.setPosition(position);
        }

        employeeMapper.updateEmployee(existingEmployee, request);

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return employeeMapper.toEmployeeResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = findEmployeeByIdOrThrow(id);
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeResponse> searchEmployees(String fullName, Long departmentId, Long positionId) {
        Specification<Employee> spec = Specification.where(null);

        if (StringUtils.hasText(fullName)) {
            spec = spec.and(EmployeeSpecifications.hasFullNameLike(fullName));
        }
        if (departmentId != null) {
            spec = spec.and(EmployeeSpecifications.hasDepartmentId(departmentId));
        }
        if (positionId != null) {
            spec = spec.and(EmployeeSpecifications.hasPositionId(positionId));
        }

        List<Employee> employees = employeeRepository.findAll(spec);

        return employeeMapper.toEmployeeResponseList(employees);
    }

    public Employee findEmployeeByIdOrThrow(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.Employee.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}
                ));
    }

    public User findUserByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.User.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}
                ));
    }

    public Department findDepartmentByIdOrThrow(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.Department.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}
                ));
    }

    public Position findPositionByIdOrThrow(Long id) {
        return positionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.Position.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}
                ));
    }
    private static class EmployeeSpecifications {

        public static Specification<Employee> hasFullNameLike(String fullName) {
            return (root, query, criteriaBuilder) -> {
                String pattern = "%" + fullName.toLowerCase() + "%";
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("fullName")), pattern);
            };
        }

        public static Specification<Employee> hasDepartmentId(Long departmentId) {
            return (root, query, criteriaBuilder) -> {
                Join<Employee, Department> departmentJoin = root.join("department", JoinType.INNER);
                return criteriaBuilder.equal(departmentJoin.get("id"), departmentId);
            };
        }

        public static Specification<Employee> hasPositionId(Long positionId) {
            return (root, query, criteriaBuilder) -> {
                Join<Employee, Position> positionJoin = root.join("position", JoinType.INNER);
                return criteriaBuilder.equal(positionJoin.get("id"), positionId);
            };
        }
    }
}