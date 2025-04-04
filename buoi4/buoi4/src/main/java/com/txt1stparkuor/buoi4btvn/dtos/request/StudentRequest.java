package com.txt1stparkuor.buoi4btvn.dtos.request;

import com.txt1stparkuor.buoi4btvn.entity.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class StudentRequest {
    @NotNull(message = "HAVING_NULL_FIELD")
    String name;
    @NotNull(message = "HAVING_NULL_FIELD")
    LocalDate dob;
    @NotNull(message = "HAVING_NULL_FIELD")
    Gender gender;
    @NotNull(message = "HAVING_NULL_FIELD")
    String email;
    @NotNull(message = "HAVING_NULL_FIELD")
    String phone;
    @NotNull(message = "HAVING_NULL_FIELD")
    String className;
}
