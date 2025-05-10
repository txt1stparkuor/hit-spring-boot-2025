package com.txt1stparkuor.buoi7.controller;

import com.txt1stparkuor.buoi7.base.ResponseUtil;
import com.txt1stparkuor.buoi7.base.RestApiV1;
import com.txt1stparkuor.buoi7.constant.UrlConstant;
import com.txt1stparkuor.buoi7.dto.request.CategoryCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.CategoryUpdateRequest;
import com.txt1stparkuor.buoi7.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestApiV1
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class CategoryController {
    CategoryService categoryService;

    @GetMapping(UrlConstant.Category.GET_CATEGORIES)
    ResponseEntity<?> getAllCategory() {
        return ResponseUtil.success(categoryService.getAllCategorys());
    }
    @GetMapping(UrlConstant.Category.GET_CATEGORY)
    ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {
        return  ResponseUtil.success(categoryService.getCategoryById(id));
    }
    @PostMapping(UrlConstant.Category.CREATE_CATEGORY)
    ResponseEntity<?> createCategory(@RequestBody @Valid CategoryCreationRequest request) {
        return  ResponseUtil.success(HttpStatus.CREATED,categoryService.createCategory(request));
    }
    @PutMapping(UrlConstant.Category.UPDATE_CATEGORY)
    ResponseEntity<?> updateCategory(@PathVariable("id") Long id,
                                     @RequestBody @Valid CategoryUpdateRequest request) {
        return  ResponseUtil.success(categoryService.updateCategory(id, request));
    }
    @DeleteMapping(UrlConstant.Category.DELETE_CATEGORY)
    ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
        return  ResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}
