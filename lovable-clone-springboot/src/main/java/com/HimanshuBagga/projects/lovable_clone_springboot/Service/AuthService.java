package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.AuthResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.LoginRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);
    AuthResponse login(LoginRequest request);
}
