package com.HimanshuBagga.projects.lovable_clone_springboot.Controller;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.AuthService;
import com.HimanshuBagga.projects.lovable_clone_springboot.Service.UserService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.AuthResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.LoginRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.SignupRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignupRequest request){
        AuthResponse authResponse = authService.signup(request);
        return ResponseEntity.ok(authResponse);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        AuthResponse authResponse = authService.login(request);
        return ResponseEntity.ok(authResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        UserProfileResponse userProfileResponse = userService.getProfile(userId);
        return ResponseEntity.ok(userProfileResponse);
    }
}
