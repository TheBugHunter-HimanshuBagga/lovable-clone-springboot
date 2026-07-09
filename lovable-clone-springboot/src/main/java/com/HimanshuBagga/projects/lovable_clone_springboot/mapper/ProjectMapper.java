package com.HimanshuBagga.projects.lovable_clone_springboot.mapper;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectSummaryResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/*
MAP-STRUCT
 */
@Mapper(componentModel = "spring")
public interface ProjectMapper {


    ProjectResponse toProjectResponse(Project project); // ProjectToProjectResponse entity to dto


    ProjectSummaryResponse toProjectSummaryResponse(Project project);
}

/*
ProjectResponse toProjectResponse(Project project);
it will be finding/ seesing all the fields inside the ProjectResponse then it will go inside the Project and map those fields

SOURCE - Project
TARGET - ProjectResponse
 */

/*
if some field names does not match b/w both the dto and entity then just use
@Mapping(source = "name" , target = "projectName")
 */
