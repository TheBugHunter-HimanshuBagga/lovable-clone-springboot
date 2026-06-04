package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.PlanLimitsResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.UsageResponseToday;

public interface UsageService {
    UsageResponseToday getTodayUsageOfUser(Long userId);
    PlanLimitsResponse getCurrentSubscriptionLimitOfTheUser(Long userId);
}
