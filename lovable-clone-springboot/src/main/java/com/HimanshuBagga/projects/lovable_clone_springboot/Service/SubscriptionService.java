package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.CheckoutRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.CheckoutResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);
}
