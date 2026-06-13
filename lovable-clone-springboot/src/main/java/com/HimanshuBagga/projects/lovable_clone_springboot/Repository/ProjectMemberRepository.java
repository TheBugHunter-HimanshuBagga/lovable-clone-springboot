package com.HimanshuBagga.projects.lovable_clone_springboot.Repository;

import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMember;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

}
