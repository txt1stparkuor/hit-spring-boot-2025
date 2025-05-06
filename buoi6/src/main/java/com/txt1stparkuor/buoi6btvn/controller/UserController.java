package com.txt1stparkuor.buoi6btvn.controller;

import com.txt1stparkuor.buoi6btvn.base.ResponseUtil;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6btvn.domain.dto.request.UserUpdateRequest;
import com.txt1stparkuor.buoi6btvn.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserController {
    UserService userService;
    @GetMapping
    ResponseEntity<?> getAllUsers() {
        return ResponseUtil.success(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        return ResponseUtil.success(userService.getUserById(id));
    }
    @PostMapping
    ResponseEntity<?> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ResponseUtil.success(HttpStatus.CREATED,userService.createUser(request));
    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserUpdateRequest request) {
        return ResponseUtil.success(userService.updateUser(id,request));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseUtil.success(HttpStatus.NO_CONTENT);
    }
}
