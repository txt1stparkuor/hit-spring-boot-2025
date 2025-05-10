package com.txt1stparkuor.buoi7.controller;

import com.txt1stparkuor.buoi7.base.ResponseUtil;
import com.txt1stparkuor.buoi7.base.RestApiV1;
import com.txt1stparkuor.buoi7.constant.UrlConstant;
import com.txt1stparkuor.buoi7.dto.request.AuthorCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.AuthorUpdateRequest;
import com.txt1stparkuor.buoi7.service.AuthorService;
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
public class AuthorController {
    AuthorService authorService;

    @GetMapping(UrlConstant.Author.GET_AUTHORS)
    ResponseEntity<?> getAllAuthor() {
        return ResponseUtil.success(authorService.getAllAuthors());
    }
    @GetMapping(UrlConstant.Author.GET_AUTHOR)
    ResponseEntity<?> getAuthorById(@PathVariable("id") Long id) {
        return  ResponseUtil.success(authorService.getAuthorById(id));
    }
    @PostMapping(UrlConstant.Author.CREATE_AUTHOR)
    ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorCreationRequest request) {
        return  ResponseUtil.success(HttpStatus.CREATED,authorService.createAuthor(request));
    }
    @PutMapping(UrlConstant.Author.UPDATE_AUTHOR)
    ResponseEntity<?> updateAuthor(@PathVariable("id") Long id,
                                   @RequestBody @Valid AuthorUpdateRequest request) {
        return  ResponseUtil.success(authorService.updateAuthor(id, request));
    }
    @DeleteMapping(UrlConstant.Author.DELETE_AUTHOR)
    ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {
        return  ResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}
