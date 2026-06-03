package com.HimanshuBagga.projects.lovable_clone_springboot.dto.project;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt
) {

}
