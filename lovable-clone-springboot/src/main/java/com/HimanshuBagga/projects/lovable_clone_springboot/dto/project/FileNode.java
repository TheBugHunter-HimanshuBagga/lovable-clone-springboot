package com.HimanshuBagga.projects.lovable_clone_springboot.dto.project;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        Long size,
        String type
) {
}
