package com.txt1stparkuor.buoi7.service.impl;

import com.txt1stparkuor.buoi7.constant.ErrorMessage;
import com.txt1stparkuor.buoi7.dto.request.AuthorCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.AuthorUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.AuthorResponse;
import com.txt1stparkuor.buoi7.dto.response.CategoryResponse;
import com.txt1stparkuor.buoi7.entity.Author;
import com.txt1stparkuor.buoi7.entity.Book;
import com.txt1stparkuor.buoi7.exception.NotFoundException;
import com.txt1stparkuor.buoi7.mapper.AuthorMapper;
import com.txt1stparkuor.buoi7.repository.AuthorRepository;
import com.txt1stparkuor.buoi7.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository;
    AuthorMapper authorMapper;
    public List<AuthorResponse> getAllAuthors() {
        return authorMapper.toAuthorResponseList(authorRepository.findAll());
    }
    public AuthorResponse createAuthor(AuthorCreationRequest request) {
        Author author= authorMapper.toAuthor(request);

        authorRepository.save(author);
        return  authorMapper.toAuthorResponse(author);
    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        Author author= authorRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(ErrorMessage.Author.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        List<Book> books=author.getBooks();
        AuthorResponse authorResponse=authorMapper.toAuthorResponse(author);
        authorResponse.setBookCount(books.size());
        return authorResponse;
    }

    public AuthorResponse updateAuthor(Long id,AuthorUpdateRequest request) {
        Author author= authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Author.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        authorMapper.updateAuthor(author,request);
        return authorMapper.toAuthorResponse(author);
    }

    public void deleteAuthor(Long id) {
        Author author= authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.Author.ERR_NOT_FOUND_ID, new String[]{String.valueOf(id)}));
        authorRepository.deleteById(id);
    }

}
