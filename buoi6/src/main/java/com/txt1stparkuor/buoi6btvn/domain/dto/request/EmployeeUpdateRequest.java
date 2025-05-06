package com.txt1stparkuor.buoi6btvn.domain.dto.request;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdateRequest {
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    Long userId;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    Long departmentId;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    Long positionId;

    @Size(max = 100, message = ErrorMessage.Validation.SIZE)
    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    String fullName;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    LocalDate dateOfBirth;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    LocalDate hiredDate;

    @PositiveOrZero(message = ErrorMessage.Validation.POSITIVE_OR_ZERO)
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    BigDecimal salary;
}