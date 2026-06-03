package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
