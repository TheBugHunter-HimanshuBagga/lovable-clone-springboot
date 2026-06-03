package com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription;

import com.HimanshuBagga.projects.lovable_clone_springboot.entity.Plan;

import java.time.Instant;

public record SubscriptionResponse(
    PlanResponse plan,
    String status,
    Instant periodEnd,
    Long tokensUsedThisCycle
) {
}
