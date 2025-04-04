package com.txt1stparkuor.buoi4btvn.dtos.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class ClassesReponse {
    String name;
    String subject;
}
