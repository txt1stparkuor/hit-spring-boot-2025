package com.txt1stparkuor.buoi4.service;

import com.txt1stparkuor.buoi4.dto.UserRequest;
import com.txt1stparkuor.buoi4.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ResourceBundle;

public interface UserService {
    List<User> getAllUsers();

    User getUser(Long id);

    User addUser(UserRequest user);

    User updateUser(UserRequest request, Long id);

    String deleteUser(Long id);
}
