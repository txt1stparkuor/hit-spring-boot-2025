package com.txt1stparkuor.buoi6btvn.domain.dto.request;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
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
public class PositionUpdateRequest {

    @Size(max = 100, message = ErrorMessage.Validation.SIZE)
    String title;
    String description;
}