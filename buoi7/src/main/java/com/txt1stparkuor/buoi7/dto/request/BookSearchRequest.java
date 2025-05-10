package com.txt1stparkuor.buoi7.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class BookSearchRequest {
    String name;
    BigDecimal price;
    Long authorId;
    Long categoryId;
}
