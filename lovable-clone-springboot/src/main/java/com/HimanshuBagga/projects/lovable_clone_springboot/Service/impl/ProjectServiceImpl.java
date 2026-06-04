package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.ProjectService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectSummaryResponse;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ProjectSummaryResponse getUserProjects(Long userId) {
        return null;
    }

    @Override
    public ProjectResponse getUserProjectById(Long Id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, Long userId) {
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
