package com.txt1stparkuor.buoi4btvn.dtos.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    @Builder.Default
    int code=1000;
    T result;
    String message;
}
