package com.txt1stparkuor.buoi7.controller;

import com.txt1stparkuor.buoi7.base.ResponseUtil;
import com.txt1stparkuor.buoi7.base.RestApiV1;
import com.txt1stparkuor.buoi7.constant.UrlConstant;
import com.txt1stparkuor.buoi7.dto.request.BookCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.BookUpdateRequest;
import com.txt1stparkuor.buoi7.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestApiV1
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class BookController {
    BookService bookService;

    @GetMapping(UrlConstant.Book.GET_BOOKS)
    ResponseEntity<?> getAllBook() {
        return ResponseUtil.success(bookService.getAllBooks());
    }
    @GetMapping(UrlConstant.Book.GET_BOOK)
    ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        return  ResponseUtil.success(bookService.getBookById(id));
    }
    @PostMapping(UrlConstant.Book.CREATE_BOOK)
    ResponseEntity<?> createBook(BookCreationRequest request) {
        return  ResponseUtil.success(HttpStatus.CREATED,bookService.createBook(request));
    }
    @PutMapping(UrlConstant.Book.UPDATE_BOOK)
    ResponseEntity<?> updateBook(@PathVariable("id") Long id, BookUpdateRequest request) {
        return  ResponseUtil.success(bookService.updateBook(id, request));
    }
    @DeleteMapping(UrlConstant.Book.DELETE_BOOK)
    ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        return  ResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}
