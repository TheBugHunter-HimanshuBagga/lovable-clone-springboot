package com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription;

public record UsageResponseToday(
        int tokensUsed,// used by You today
        int tokensList, // coming from the plan
        int previewRunning, // used by You today
        int previewLimit // coming from the plan
) {
}
