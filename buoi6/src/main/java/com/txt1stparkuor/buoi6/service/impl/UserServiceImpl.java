package com.txt1stparkuor.buoi6.service.impl;

import com.txt1stparkuor.buoi6.mapper.UserMapper;
import com.txt1stparkuor.buoi6.model.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6.model.dto.request.UserUpdateRequest;
import com.txt1stparkuor.buoi6.model.dto.response.UserResponse;
import com.txt1stparkuor.buoi6.model.entity.User;
import com.txt1stparkuor.buoi6.repository.UserRepository;
import com.txt1stparkuor.buoi6.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.toUserResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found "))
        );
    }

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        User user=userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(String id,UserUpdateRequest request) {
        User user=userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserResponse(userRepository.save(userMapper.updateUser(user,request)));
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserResponse getUserByName(String name) {
        User user=userRepository.findByUsername(name);
        return userMapper.toUserResponse(user);
    }
}
