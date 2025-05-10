package com.txt1stparkuor.buoi7.mapper;

import com.txt1stparkuor.buoi7.dto.request.AuthorCreationRequest;
import com.txt1stparkuor.buoi7.dto.request.AuthorUpdateRequest;
import com.txt1stparkuor.buoi7.dto.response.AuthorResponse;
import com.txt1stparkuor.buoi7.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponse toAuthorResponse(Author author);
    Author toAuthor(AuthorCreationRequest request);
    List<AuthorResponse> toAuthorResponseList(List<Author> authors);
    void updateAuthor(@MappingTarget  Author author, AuthorUpdateRequest request);
}
