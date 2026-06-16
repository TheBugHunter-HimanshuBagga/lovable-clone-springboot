package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectMemberRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.UserRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Service.ProjectMemberService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.InviteMemberRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.MemberResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.UpdateMemberRoleRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.Project;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMember;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMemberId;
import com.HimanshuBagga.projects.lovable_clone_springboot.mapper.ProjectMemberMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    UserRepository userRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        /*
         first we need to check that is that member already authenticated and get it from SecurityContextHolder
         AUTHENTICATION will be added LATER
         */


        // if that project doesn't exists
        Project project = projectRepository.findAccessibleProjectById(projectId,userId);

        // if my project Exists then return its owner + members(ProjectMembers)
        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner())); // till now only owner is added in this List

        // Adding the projectMember
        memberResponseList.addAll(projectMemberRepository.findByIdProjectId(projectId)
                .stream()// i am getting ProjectMember but i need it to be in MemberResponse hence we will be using the MapStruct
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList()
        );

        return memberResponseList;
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
