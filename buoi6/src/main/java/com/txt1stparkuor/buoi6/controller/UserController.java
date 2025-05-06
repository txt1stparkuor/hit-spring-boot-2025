package com.txt1stparkuor.buoi6.controller;

import com.txt1stparkuor.buoi6.model.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6.model.dto.request.UserUpdateRequest;
import com.txt1stparkuor.buoi6.model.dto.response.UserResponse;
import com.txt1stparkuor.buoi6.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/users")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreationRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") String id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(userService.updateUser(id,request));
    }
}
