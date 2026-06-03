package com.HimanshuBagga.projects.lovable_clone_springboot.Controller;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.PlanService;
import com.HimanshuBagga.projects.lovable_clone_springboot.Service.SubscriptionService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.CheckoutResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.CheckoutRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.PlanResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.SubscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class BillingController {
    private final PlanService planService;
    private final SubscriptionService subscriptionService;
    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans(){
        List<PlanResponse> planResponse = planService.getAllActivePlans();
        return ResponseEntity.ok(planResponse);
    }
    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId = 1L;
        SubscriptionResponse subscriptionResponse = subscriptionService.getCurrentSubscription(userId);
        return ResponseEntity.ok(subscriptionResponse);
    }
    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody CheckoutRequest request){
        Long userId = 1L;
        CheckoutResponse response = subscriptionService.createCheckoutSessionUrl(request);
        return ResponseEntity.ok(response);
    }
}
