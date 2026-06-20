package com.HimanshuBagga.projects.lovable_clone_springboot.dto.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
    @NotBlank String name
) {
}
