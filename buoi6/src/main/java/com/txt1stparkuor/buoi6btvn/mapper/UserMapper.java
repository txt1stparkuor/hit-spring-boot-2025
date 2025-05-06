package com.txt1stparkuor.buoi6btvn.mapper;

import com.txt1stparkuor.buoi6btvn.domain.entity.User;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.UserResponse;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponseList(List<User> users);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
