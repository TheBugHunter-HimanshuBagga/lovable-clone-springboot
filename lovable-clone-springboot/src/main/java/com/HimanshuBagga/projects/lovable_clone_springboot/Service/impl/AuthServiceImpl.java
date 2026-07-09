package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.UserRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Service.AuthService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.AuthResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.LoginRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.SignupRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import com.HimanshuBagga.projects.lovable_clone_springboot.error.BadRequestException;
import com.HimanshuBagga.projects.lovable_clone_springboot.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request){

        userRepository.findByUsername(request.username()).ifPresent( user -> {
                throw new BadRequestException("User already exists with username: " + request.username());
            }
        );

        // otherwise -> use builder pattern or a mapper pattern

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);


        return new AuthResponse("dummy",userMapper.toUserProfileResponse(user));
    }
    @Override
    public AuthResponse login(LoginRequest request){
        return null;
    }
}
