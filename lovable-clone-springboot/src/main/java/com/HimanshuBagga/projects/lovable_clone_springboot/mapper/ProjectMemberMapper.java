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

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "name", source = "user.name")
//    @Mapping(target = "avatarUrl", source = "user.avatarUrl")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
/*
Source: User
Target: MemberResponse

Used to make the null fields
 */