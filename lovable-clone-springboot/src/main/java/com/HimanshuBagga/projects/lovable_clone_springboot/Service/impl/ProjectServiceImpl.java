package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.ProjectRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Repository.UserRepository;
import com.HimanshuBagga.projects.lovable_clone_springboot.Service.ProjectService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectSummaryResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.Project;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import com.HimanshuBagga.projects.lovable_clone_springboot.mapper.ProjectMapper;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

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

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        project = projectRepository.save(project);
        // Entity to record -> MAPSTRUCT
        // savedProjectToProjectResponse
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectRepository.findAllAccessibleByUser(userId)
                .stream()
                .map(project -> projectMapper.toProjectSummaryResponse(project))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getUserProjectById(Long Id, Long userId) {
        return null;
    }


    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
