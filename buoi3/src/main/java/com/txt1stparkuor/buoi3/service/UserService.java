package com.txt1stparkuor.buoi3.service;

import com.txt1stparkuor.buoi3.entity.User;
import com.txt1stparkuor.buoi3.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
