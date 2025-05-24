package com.txt1stparkuor.buoi8.service.impl;

import com.txt1stparkuor.buoi8.domain.dto.request.AuthRequest;
import com.txt1stparkuor.buoi8.domain.dto.response.AuthResponse;
import com.txt1stparkuor.buoi8.domain.entity.User;
import com.txt1stparkuor.buoi8.exception.UnauthorizedException;
import com.txt1stparkuor.buoi8.repository.UserRepository;
import com.txt1stparkuor.buoi8.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse login(AuthRequest request) {
        String username=request.getUsername();
        String password=request.getPassword();
        User user=userRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("exception.auth.invalid-credentials", null));
        if (!passwordEncoder.matches(password,user.getPassword()))
            throw new UnauthorizedException("exception.auth.invalid-credentials", null);
        return new AuthResponse("Login successfully");
    }
}
