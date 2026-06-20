package com.HimanshuBagga.projects.lovable_clone_springboot.dto.member;

import com.HimanshuBagga.projects.lovable_clone_springboot.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role
) {
}
