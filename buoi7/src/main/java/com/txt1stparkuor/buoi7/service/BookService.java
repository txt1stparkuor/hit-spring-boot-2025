package com.txt1stparkuor.buoi7.service;

import com.txt1stparkuor.buoi7.dto.request.BookCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.BookUpdateRequest;
import com.txt1stparkuor.buoi7.dto.request.CategoryCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.CategoryUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.BookResponse;
import com.txt1stparkuor.buoi7.dto.response.CategoryResponse;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();
    BookResponse updateBook(Long id, BookUpdateRequest request);
    BookResponse createBook(BookCreationRequest request);
    BookResponse getBookById(Long id);
    void deleteBook(Long id);
    List<BookResponse> searchBooks(String name, BigDecimal price, Long authorId, Long categoryId);
}
