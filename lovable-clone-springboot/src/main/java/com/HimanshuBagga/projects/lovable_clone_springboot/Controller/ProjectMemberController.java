package com.HimanshuBagga.projects.lovable_clone_springboot.Controller;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.ProjectMemberService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.InviteMemberRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.MemberResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.member.UpdateMemberRoleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        Long userId = 1L;
        List<MemberResponse> memberResponse = projectMemberService.getProjectMembers(projectId,userId);
        return ResponseEntity.ok(memberResponse);
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId,
                                                       @RequestBody InviteMemberRequest inviteMemberRequest){
        Long usedId = 1L;
        MemberResponse memberResponse = projectMemberService.inviteMember(projectId , inviteMemberRequest , usedId);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponse);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectId ,
                                                           @PathVariable Long memberId ,
                                                           @RequestBody UpdateMemberRoleRequest updateMemberRoleRequest){
        Long userId = 1L;
        MemberResponse memberResponse = projectMemberService.updateMemberRole(projectId , memberId , updateMemberRoleRequest , userId);
        return ResponseEntity.ok(memberResponse);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long projectId,
                                             @PathVariable Long memberId){
        Long userId = 1L;
        projectMemberService.deleteProjectMember(projectId , memberId , userId);
        return ResponseEntity.noContent().build();
    }
}
