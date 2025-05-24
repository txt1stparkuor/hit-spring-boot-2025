package com.txt1stparkuor.buoi8.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequest {
    @NotBlank(message = "{invalid.general.not-blank}")
    String username;
    @NotBlank(message = "{invalid.general.not-blank}")
    String password;
}
