package com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription;

public record UsageResponseToday(
        Integer tokensUsed,// used by You today
        Integer tokensList, // coming from the plan
        Integer previewRunning, // used by You today
        Integer previewLimit // coming from the plan
) {
}
