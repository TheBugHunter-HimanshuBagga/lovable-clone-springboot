package com.HimanshuBagga.projects.lovable_clone_springboot.Repository;

import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMember;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    // for getting the ProjectMembers involved inside a project
    List<ProjectMember> findByIdProjectId(Long projectId);
}

/*
My ProjectMember contains

    @EmbeddedId
    ProjectMemberId id;

    now inside this i have

    Long projectId;
    Long userId;

    from which i want to access only the ProjectId
 */
