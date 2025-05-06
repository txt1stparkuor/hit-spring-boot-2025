package com.txt1stparkuor.buoi6btvn.service;

import com.txt1stparkuor.buoi6btvn.domain.dto.response.UserResponse;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserUpdateRequest;
import java.util.List;
public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse createUser(UserCreationRequest request);
    UserResponse updateUser(Long id,UserUpdateRequest request);
    void deleteUser(Long id);
}
