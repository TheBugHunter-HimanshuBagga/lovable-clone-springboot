package com.HimanshuBagga.projects.lovable_clone_springboot.mapper;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.MemberResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.ProjectMember;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    @Mapping(target= "userId" , source = "id")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
/*
Source: User
Target: MemberResponse
 */