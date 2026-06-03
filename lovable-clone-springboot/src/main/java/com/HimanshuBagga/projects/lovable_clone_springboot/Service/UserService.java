package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile(Long userId);
}
