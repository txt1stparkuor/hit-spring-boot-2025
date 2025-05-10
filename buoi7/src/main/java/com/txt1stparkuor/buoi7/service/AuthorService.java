package com.txt1stparkuor.buoi7.service;


import com.txt1stparkuor.buoi7.dto.request.AuthorCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.AuthorUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();
    AuthorResponse updateAuthor(Long id, AuthorUpdateRequest request);
    AuthorResponse createAuthor(AuthorCreationRequest request);
    AuthorResponse getAuthorById(Long id);
    void deleteAuthor(Long id);
}
