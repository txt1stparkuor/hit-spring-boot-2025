package com.txt1stparkuor.buoi7.dto.request;

import com.txt1stparkuor.buoi7.constant.ErrorMessage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCreationRequest {
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    String name;
    String description;
    @Positive(message = ErrorMessage.Validation.POSITIVE)
    BigDecimal price;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    Long authorId;
    @NotNull(message = ErrorMessage.Validation.NOT_NULL)
    Long categoryId;
}
