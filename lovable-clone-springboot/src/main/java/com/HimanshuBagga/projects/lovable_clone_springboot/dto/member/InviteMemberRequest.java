package com.HimanshuBagga.projects.lovable_clone_springboot.dto.member;

import com.HimanshuBagga.projects.lovable_clone_springboot.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
