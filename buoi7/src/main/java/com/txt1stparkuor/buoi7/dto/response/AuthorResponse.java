package com.txt1stparkuor.buoi7.dto.response;

import com.txt1stparkuor.buoi7.constant.ErrorMessage;
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
public class AuthorResponse {
    String name;
    LocalDate dob;
    String bio;
    int bookCount;
}
