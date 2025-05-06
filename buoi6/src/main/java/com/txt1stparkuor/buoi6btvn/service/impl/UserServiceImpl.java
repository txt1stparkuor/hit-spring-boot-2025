package com.txt1stparkuor.buoi6btvn.service.impl;

import com.txt1stparkuor.buoi6btvn.constant.ErrorMessage;
import com.txt1stparkuor.buoi6btvn.domain.entity.User;
import com.txt1stparkuor.buoi6btvn.domain.dto.response.UserResponse;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserUpdateRequest;
import com.txt1stparkuor.buoi6btvn.exception.DuplicateResourceException;
import com.txt1stparkuor.buoi6btvn.exception.NotFoundException;
import com.txt1stparkuor.buoi6btvn.mapper.UserMapper;
import com.txt1stparkuor.buoi6btvn.repository.UserRepository;
import com.txt1stparkuor.buoi6btvn.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    @NonFinal
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.toUserResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.User.ERR_NOT_FOUND_ID,
                        new String[]{String.valueOf(id)}
                ));
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException(
                    ErrorMessage.DUPLICATE_RESOURCE,
                    new String[]{"Username: " + request.getUsername()}
            );
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException(
                    ErrorMessage.DUPLICATE_RESOURCE,
                    new String[]{"Email: " + request.getEmail()}
            );
        }

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        ErrorMessage.User.ERR_NOT_FOUND_ID,
                        new String[]{String.valueOf(id)}
                ));

        if (!request.getEmail().equalsIgnoreCase(existingUser.getEmail())) {
            if (userRepository.existsByEmailAndIdNot(request.getEmail(), id)) {
                throw new DuplicateResourceException(
                        ErrorMessage.DUPLICATE_RESOURCE,
                        new String[]{"Email: " + request.getEmail()}
                );
            }
        }

        userMapper.updateUser(existingUser, request);
        existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
