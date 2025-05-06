package com.txt1stparkuor.buoi6btvn.domain.dto.response;

import com.txt1stparkuor.buoi6btvn.domain.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
    PositionResponse position;
    DepartmentResponse department;
    UserResponse user;
    String fullName;
    LocalDate dateOfBirth;
    LocalDate hiredDate;
    BigDecimal salary;
}
