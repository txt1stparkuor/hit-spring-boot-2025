package com.txt1stparkuor.buoi4btvn.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class ClassesRequest {
    @NotNull(message = "HAVING_NULL_FIELD")
    String name;
    @NotNull(message = "HAVING_NULL_FIELD")
    String subject;
}
