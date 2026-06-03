package com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth;

public record LoginRequest(
    String email,
    String password
) {
}
