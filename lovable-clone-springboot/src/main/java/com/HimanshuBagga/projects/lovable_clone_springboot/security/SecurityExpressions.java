package com.HimanshuBagga.projects.lovable_clone_springboot.security;

import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectMemberRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.enums.ProjectRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions { // security methods

    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;

    public boolean canViewProject(Long projectId){
        Long userId = authUtil.getCurrentUserId();
        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId , userId).
                map(role -> role.equals(ProjectRole.EDITOR) || role.equals(ProjectRole.VIEWER) || role.equals(ProjectRole.OWNER)).
                orElse(false);

    }

    public boolean canEditProject(Long projectId){
        Long userId = authUtil.getCurrentUserId();
        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId , userId).
                map(role -> role.equals(ProjectRole.EDITOR) || role.equals(ProjectRole.OWNER)).
                orElse(false);
    }

}

/*
Deal with the authorization before even going to the service Layer
 */
