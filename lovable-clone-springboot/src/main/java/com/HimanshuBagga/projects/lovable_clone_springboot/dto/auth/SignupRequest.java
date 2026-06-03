package com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
