package com.txt1stparkuor.buoi7.dto.request;

import com.txt1stparkuor.buoi7.constant.ErrorMessage;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorCreationRequest {
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    String name;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    LocalDate dob;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    String bio;
}
