package com.txt1stparkuor.buoi6btvn.domain.dto.request;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage; // Import ErrorMessage
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    @Size(min = 6, max = 255, message = ErrorMessage.Validation.SIZE)
    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    String password;
    @Email(message = ErrorMessage.Validation.EMAIL)
    @Size(max = 100, message = ErrorMessage.Validation.SIZE)
    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    String email;
}