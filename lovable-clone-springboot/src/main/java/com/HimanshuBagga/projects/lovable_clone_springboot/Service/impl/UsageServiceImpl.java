package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.UsageService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.PlanLimitsResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.UsageResponseToday;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageResponseToday getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitOfTheUser(Long userId) {
        return null;
    }
}
