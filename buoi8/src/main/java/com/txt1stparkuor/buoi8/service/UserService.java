package com.txt1stparkuor.buoi8.service;



import com.txt1stparkuor.buoi8.domain.dto.request.UserCreateDto;
import com.txt1stparkuor.buoi8.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserCreateDto userCreateDto);
    List<UserDto> getAllUsers();
}
