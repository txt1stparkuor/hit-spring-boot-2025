package com.txt1stparkuor.buoi6.service;

import com.txt1stparkuor.buoi6.model.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6.model.dto.request.UserUpdateRequest;
import com.txt1stparkuor.buoi6.model.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse getUserById(String id);
    UserResponse createUser(UserCreationRequest user);
    UserResponse updateUser(String id,UserUpdateRequest user);
    void deleteUser(Long id);
    UserResponse getUserByName(String name);
}
