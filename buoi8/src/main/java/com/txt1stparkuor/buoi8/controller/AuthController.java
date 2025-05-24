package com.txt1stparkuor.buoi8.controller;

import com.txt1stparkuor.buoi8.base.ResponseUtil;
import com.txt1stparkuor.buoi8.domain.dto.request.AuthRequest;
import com.txt1stparkuor.buoi8.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        return ResponseUtil.success(authService.login(request));
    }
}
