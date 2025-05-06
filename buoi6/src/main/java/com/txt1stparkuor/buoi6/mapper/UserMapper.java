package com.txt1stparkuor.buoi6.mapper;

import com.txt1stparkuor.buoi6.model.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6.model.dto.request.UserUpdateRequest;
import com.txt1stparkuor.buoi6.model.dto.response.UserResponse;
import com.txt1stparkuor.buoi6.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User toUser(UserCreationRequest request);
    User updateUser(@MappingTarget User user, UserUpdateRequest request);
    List<UserResponse> toUserResponseList(List<User> users);
}
