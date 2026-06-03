package com.HimanshuBagga.projects.lovable_clone_springboot.dto.member;

import com.HimanshuBagga.projects.lovable_clone_springboot.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long id,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
