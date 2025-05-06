package com.txt1stparkuor.buoi6btvn.domain.dto.request;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentUpdateRequest {

    @Size(max = 100, message = ErrorMessage.Validation.SIZE)
    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    String name;

    String description;
}