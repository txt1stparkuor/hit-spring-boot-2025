package com.txt1stparkuor.buoi8.service;

import com.txt1stparkuor.buoi8.domain.dto.request.AuthRequest;
import com.txt1stparkuor.buoi8.domain.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
}
