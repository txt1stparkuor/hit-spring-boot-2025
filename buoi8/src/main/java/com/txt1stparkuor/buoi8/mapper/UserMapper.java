package com.txt1stparkuor.buoi8.mapper;


import com.txt1stparkuor.buoi8.domain.dto.request.UserCreateDto;
import com.txt1stparkuor.buoi8.domain.dto.response.UserDto;
import com.txt1stparkuor.buoi8.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreateDto userCreateDTO);

    UserDto toUserDto(User user);

    List<UserDto> toUserDtos(List<User> user);
}
