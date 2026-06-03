package com.HimanshuBagga.projects.lovable_clone_springboot.dto.project;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
