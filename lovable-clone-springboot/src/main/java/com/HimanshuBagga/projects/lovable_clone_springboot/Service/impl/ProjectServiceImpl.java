package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectMemberRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.UserRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Service.ProjectService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectSummaryResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.Project;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMember;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMemberId;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import com.HimanshuBagga.projects.lovable_clone_springboot.enums.ProjectRole;
import com.HimanshuBagga.projects.lovable_clone_springboot.error.ResourceNotFoundException;
import com.HimanshuBagga.projects.lovable_clone_springboot.mapper.ProjectMapper;
import com.HimanshuBagga.projects.lovable_clone_springboot.security.AuthUtil;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;
    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
//        User owner = userRepository.findById(userId).orElseThrow(
//                () -> new ResourceNotFoundException("User" , userId.toString())
//        ); this will be making a db call but we don't need the full object

        User owner = userRepository.getReferenceById(userId); // hibernate create a proxy of this and gives us the response only works inside a Transactional context

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);
        // Entity to record -> MAPSTRUCT
        // savedProjectToProjectResponse
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(project -> projectMapper.toProjectSummaryResponse(project))
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("@security.canViewProject(#id)") // Uses AOP reduces the
    public ProjectResponse getUserProjectById(Long id) { // projectId
        Long userId = authUtil.getCurrentUserId();
        Project project = projectRepository.findAccessibleProjectById(id , userId).orElseThrow(
                () -> new ResourceNotFoundException("Project",id.toString()) // if project is not found then it will be caught by Global Exception Handler ResourceNotFound
        );
        return projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = projectRepository.findAccessibleProjectById(id , userId).orElseThrow(
                () -> new ResourceNotFoundException("Project",id.toString())
        );
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("You are not allowed to update the name");
//        }
        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = projectRepository.findAccessibleProjectById(id , userId).orElseThrow();
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("You are not allowed to delete");
//        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }
}
