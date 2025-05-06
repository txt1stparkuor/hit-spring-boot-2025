package com.txt1stparkuor.buoi6btvn.domain.dto.response;

import com.txt1stparkuor.buoi6btvn.domain.entity.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String username;
    String email;
    Date createdAt;
}
