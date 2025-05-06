package com.txt1stparkuor.buoi6.model.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    String password;
    String firstName;
    String lastName;
}
