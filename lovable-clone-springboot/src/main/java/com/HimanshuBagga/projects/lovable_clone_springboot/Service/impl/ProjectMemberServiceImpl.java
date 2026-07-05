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
import com.HimanshuBagga.projects.lovable_clone_springboot.error.ResourceNotFoundException;
import com.HimanshuBagga.projects.lovable_clone_springboot.mapper.ProjectMapper;
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
        Project project = projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow(
               () -> new ResourceNotFoundException("Project",projectId.toString())
        );

        // if my project Exists then return its owner + members(ProjectMembers)
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()// i am getting ProjectMember but i need it to be in MemberResponse hence we will be using the MapStruct
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();

    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {

        // to invite a memeber we need a particular project to add him in that Project hence
        Project project = projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();

        // only project owner can invite the people right
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException(
//                    "You are not allowed to add/invite the people in the project"
//            );
//        }

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
        // first we need to check that is that user Authenticated right also with this we need to check wheather the person updating is an owner or not right

        // check weather the particular project exists or not where i need to update the userRole
        Project project = projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();

//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("You are not allowed to Update/Change the role of a member");
//        }

        // if the projects i got then and the updateor is an owner then:
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId); // whom to update?
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow(); // exists or not

        projectMember.setProjectRole(updateMemberRoleRequest.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();

//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException(
//                    "Ypu can't remove the project Member/You don't have permission to remove the project Member"
//            );
//        }

        // find the projectMember
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException(
                    "Doesn't Exists"
            );
        }

        // if he/she is owner then
        projectMemberRepository.deleteById(projectMemberId);
    }
}
