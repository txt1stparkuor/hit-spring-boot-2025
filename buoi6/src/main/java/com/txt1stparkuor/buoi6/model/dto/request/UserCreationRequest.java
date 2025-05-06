package com.txt1stparkuor.buoi6.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
     @NotNull
     String username;
     @NotNull
     String password;
     @NotBlank
     String firstName;
     @NotBlank
     String lastName;
}
