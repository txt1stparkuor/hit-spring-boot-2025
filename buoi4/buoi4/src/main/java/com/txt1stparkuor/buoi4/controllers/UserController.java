package com.txt1stparkuor.buoi4.controllers;

import com.txt1stparkuor.buoi4.dto.UserRequest;
import com.txt1stparkuor.buoi4.models.User;
import com.txt1stparkuor.buoi4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/add")
    User addUser(@RequestBody UserRequest request) {
        return userService.addUser(request);
    }

    @PutMapping("/update/{userId}")
    User updateUser(@RequestBody UserRequest request, @PathVariable("userId") Long id) {
        return userService.updateUser(request,id);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") Long id) {
        return userService.deleteUser(id);
    }

}
