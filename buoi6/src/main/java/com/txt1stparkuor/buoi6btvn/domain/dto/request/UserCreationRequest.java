package com.txt1stparkuor.buoi6btvn.domain.dto.request;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    @Size(min = 3, max = 50, message = ErrorMessage.Validation.SIZE)
    String username;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    @Size(min = 6, max = 255, message = ErrorMessage.Validation.SIZE)
    String password;

    @NotBlank(message = ErrorMessage.Validation.NOT_BLANK)
    @Email(message = ErrorMessage.Validation.EMAIL)
    @Size(max = 100, message = ErrorMessage.Validation.SIZE)
    String email;
}