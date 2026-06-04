package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.SubscriptionService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.CheckoutRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.CheckoutResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.PortalResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.SubscriptionResponse;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
