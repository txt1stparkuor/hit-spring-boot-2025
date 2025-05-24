package com.txt1stparkuor.buoi8.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDto {
    @NotBlank(message = "{invalid.general.not-blank}")
    private String username;

    @NotBlank(message = "{invalid.general.not-blank}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", message = "{invalid.password.invalid-format}")
    private String password;

    @NotBlank(message = "{invalid.general.not-blank}")
    private String firstName;

    @NotBlank(message = "{invalid.general.not-blank}")
    private String lastName;
}
