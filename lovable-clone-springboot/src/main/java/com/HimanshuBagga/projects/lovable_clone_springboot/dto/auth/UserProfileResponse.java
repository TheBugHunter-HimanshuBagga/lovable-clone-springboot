package com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
