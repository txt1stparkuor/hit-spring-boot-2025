package com.txt1stparkuor.buoi7.mapper;

import com.txt1stparkuor.buoi7.dto.request.BookCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.BookUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.BookResponse;
import com.txt1stparkuor.buoi7.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse toBookResponse(Book book);


    @Mapping(target = "category", ignore = true)
    @Mapping(target = "author", ignore = true)
    Book toBook(BookCreationRequest request);

    List<BookResponse> toBookResponseList(List<Book> categories);

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "author", ignore = true)
    void updateBook(@MappingTarget Book book, BookUpdateRequest request);
}
