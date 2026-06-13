package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectMemberRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.UserRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Service.ProjectMemberService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.InviteMemberRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.MemberResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.UpdateMemberRoleRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMember;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest updateMemberRoleRequest, Long userId) {
        return null;
    }

    @Override
    public void deleteProjectMember(Long projectId, Long memberId, Long userId) {

    }
}
