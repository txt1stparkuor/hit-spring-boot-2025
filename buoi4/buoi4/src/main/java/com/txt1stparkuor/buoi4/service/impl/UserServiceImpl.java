package com.txt1stparkuor.buoi4.service.impl;

import com.txt1stparkuor.buoi4.dto.UserRequest;
import com.txt1stparkuor.buoi4.models.User;
import com.txt1stparkuor.buoi4.repositories.UserRepository;
import com.txt1stparkuor.buoi4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    @Override
    public User addUser(@RequestBody UserRequest request) {
        User user=new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UserRequest request, Long id) {
        User currentUser=getUser(id);
        currentUser.setName(request.getName());
        currentUser.setEmail(request.getEmail());
        return userRepository.save(currentUser);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "Deleted sucessfully";
    }
}
