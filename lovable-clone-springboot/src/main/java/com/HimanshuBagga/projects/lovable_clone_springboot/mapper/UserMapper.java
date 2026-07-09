package com.HimanshuBagga.projects.lovable_clone_springboot.mapper;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.AuthResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.SignupRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.auth.UserProfileResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
