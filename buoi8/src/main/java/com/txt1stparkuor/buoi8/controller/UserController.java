package com.txt1stparkuor.buoi8.controller;


import com.txt1stparkuor.buoi8.base.ResponseUtil;
import com.txt1stparkuor.buoi8.domain.dto.request.UserCreateDto;
import com.txt1stparkuor.buoi8.domain.dto.response.UserDto;
import com.txt1stparkuor.buoi8.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreateDto dto) {
        return ResponseUtil.success(userService.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseUtil.success(userService.getAllUsers());
    }
}
