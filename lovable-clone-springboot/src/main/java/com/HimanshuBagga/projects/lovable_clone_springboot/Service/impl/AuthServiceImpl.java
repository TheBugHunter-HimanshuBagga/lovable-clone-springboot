package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.AuthService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.AuthResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.LoginRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest request){
        return null;
    }
    @Override
    public AuthResponse login(LoginRequest request){
        return null;
    }
}
