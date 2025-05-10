package com.txt1stparkuor.buoi7.service.impl;

import com.txt1stparkuor.buoi7.constant.ErrorMessage;
import com.txt1stparkuor.buoi7.dto.request.CategoryCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.CategoryUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.CategoryResponse;
import com.txt1stparkuor.buoi7.entity.Book;
import com.txt1stparkuor.buoi7.entity.Category;
import com.txt1stparkuor.buoi7.exception.NotFoundException;
import com.txt1stparkuor.buoi7.mapper.CategoryMapper;
import com.txt1stparkuor.buoi7.repository.CategoryRepository;
import com.txt1stparkuor.buoi7.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;
    public List<CategoryResponse> getAllCategorys() {
        return categoryMapper.toCategoryResponseList(categoryRepository.findAll());
    }
    public CategoryResponse createCategory(CategoryCreationRequest request) {
        Category category= categoryMapper.toCategory(request);
        categoryRepository.save(category);
        return  categoryMapper.toCategoryResponse(category);
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category= categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Category.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        List<Book> books=category.getBooks();
        CategoryResponse categoryResponse=categoryMapper.toCategoryResponse(category);
        categoryResponse.setBookCount(books.size());
        return categoryResponse;
    }

    public CategoryResponse updateCategory(Long id, CategoryUpdateRequest request) {
        Category category= categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Category.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        categoryMapper.updateCategory(category,request);
        return categoryMapper.toCategoryResponse(category);
    }

    public void deleteCategory(Long id) {
        Category category= categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Category.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        categoryRepository.deleteById(id);
    }
}
