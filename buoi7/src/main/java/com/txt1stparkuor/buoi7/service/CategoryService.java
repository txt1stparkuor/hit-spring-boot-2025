package com.txt1stparkuor.buoi7.service;

import com.txt1stparkuor.buoi7.dto.request.AuthorCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.AuthorUpdateRequest;
import com.txt1stparkuor.buoi7.dto.request.CategoryCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.CategoryUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.AuthorResponse;
import com.txt1stparkuor.buoi7.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategorys();
    CategoryResponse updateCategory(Long id, CategoryUpdateRequest request);
    CategoryResponse createCategory(CategoryCreationRequest request);
    CategoryResponse getCategoryById(Long id);
    void deleteCategory(Long id);
}
