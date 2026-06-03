package com.HimanshuBagga.projects.lovable_clone_springboot.entity;

import com.HimanshuBagga.projects.lovable_clone_springboot.enums.ProjectRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMember {
    ProjectMemberId id;
    Project project;
    User user;
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
