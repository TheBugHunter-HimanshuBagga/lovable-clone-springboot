package com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}

/*
Record -> special type of class

whenever i login i will get the token as well as UserProfileResponse
 */