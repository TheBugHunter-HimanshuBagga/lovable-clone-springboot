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
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import com.HimanshuBagga.projects.lovable_clone_springboot.mapper.ProjectMemberMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

        // to invite a memeber we need a particular project to add him in that Project hence
        Project project = projectRepository.findAccessibleProjectById(projectId,userId);

        // only project owner can invite the people right
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException(
                    "You are not allowed to add/invite the people in the project"
            );
        }

        // for inviting a person i need his/her email and role hence
        User invitee = userRepository.findByEmail(request.email()).orElseThrow();

        // may be owner is trying to invite himself?
        if(invitee.getId().equals(userId)){
            throw new RuntimeException(
                    "Can't invite yourself"
            );
        }

        // invitee should not be present earlier in the projectMembers
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId , invitee.getId());

        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException(
                    "Can't invite once again"
            );
        }

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest updateMemberRoleRequest, Long userId) {
        return null;
    }

    @Override
    public void deleteProjectMember(Long projectId, Long memberId, Long userId) {

    }
}
