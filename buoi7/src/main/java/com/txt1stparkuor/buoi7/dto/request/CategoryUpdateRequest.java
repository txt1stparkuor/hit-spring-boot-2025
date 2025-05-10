package com.txt1stparkuor.buoi7.dto.request;

import com.txt1stparkuor.buoi7.constant.ErrorMessage;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryUpdateRequest {
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    String name;
}
