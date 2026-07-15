package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.InviteMemberRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.MemberResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);
    MemberResponse inviteMember(Long projectId , InviteMemberRequest request);
    MemberResponse updateMemberRole(Long projectId , Long memberId , UpdateMemberRoleRequest updateMemberRoleRequest);
    void removeProjectMember(Long projectId , Long memberId);
}
