package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);
    ProjectResponse getUserProjectById(Long Id , Long userId);
    ProjectResponse createProject(ProjectRequest projectRequest , Long userId);
    ProjectResponse updateProject(Long id , ProjectRequest request , Long userId);
    void softDelete(Long id , Long userId);

}
