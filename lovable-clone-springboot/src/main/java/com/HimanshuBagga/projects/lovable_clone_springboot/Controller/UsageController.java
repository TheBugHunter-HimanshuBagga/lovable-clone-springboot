package com.HimanshuBagga.projects.lovable_clone_springboot.Controller;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.UsageService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.PlanLimitsResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.UsageResponseToday;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {
    private final UsageService usageService;
    @GetMapping("/today")
    public ResponseEntity<UsageResponseToday> getTodayUsage(){
        Long userId = 1L;
        UsageResponseToday usageResponseToday = usageService.getTodayUsageOfUser(userId);
        return ResponseEntity.ok(usageResponseToday);
    }
    @GetMapping("/limits")
    public ResponseEntity<PlanLimitsResponse> getPlanLimits(){
        Long userId = 1L;
        PlanLimitsResponse planLimitsResponse = usageService.getCurrentSubscriptionLimitOfTheUser(userId);
        return ResponseEntity.ok(planLimitsResponse);
    }
}
