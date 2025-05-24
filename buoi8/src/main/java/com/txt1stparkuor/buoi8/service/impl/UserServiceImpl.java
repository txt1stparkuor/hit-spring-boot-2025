package com.txt1stparkuor.buoi8.service.impl;

import com.txt1stparkuor.buoi8.domain.dto.request.UserCreateDto;
import com.txt1stparkuor.buoi8.domain.dto.response.UserDto;
import com.txt1stparkuor.buoi8.domain.entity.User;
import com.txt1stparkuor.buoi8.exception.DuplicateResourceException;
import com.txt1stparkuor.buoi8.mapper.UserMapper;
import com.txt1stparkuor.buoi8.repository.UserRepository;
import com.txt1stparkuor.buoi8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        if (userRepository.existsByUsername(userCreateDto.getUsername()))
            throw new DuplicateResourceException(
                    "exception.duplicate.resource",
                    new String[]{"username "+userCreateDto.getUsername()}
            );
        User user = userMapper.toUser(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toUserDtos(userRepository.findAll());
    }
}
