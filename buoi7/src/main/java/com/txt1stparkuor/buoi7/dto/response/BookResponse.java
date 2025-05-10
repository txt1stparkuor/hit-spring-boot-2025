package com.txt1stparkuor.buoi7.dto.response;

import com.txt1stparkuor.buoi7.entity.Author;
import com.txt1stparkuor.buoi7.entity.Category;
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
public class BookResponse {
    String name;
    String description;
    BigDecimal price;
    Author author;
    Category category;
    //CUOI GIO EM MOI DE Y CAI REPSPONSE
}
