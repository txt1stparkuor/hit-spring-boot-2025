package com.txt1stparkuor.buoi7.mapper;

import com.txt1stparkuor.buoi7.dto.request.CategoryCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.CategoryUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.CategoryResponse;
import com.txt1stparkuor.buoi7.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toCategoryResponse(Category category);

    Category toCategory(CategoryCreationRequest request);

    List<CategoryResponse> toCategoryResponseList(List<Category> categories);

    void updateCategory(@MappingTarget Category category, CategoryUpdateRequest request);
}
