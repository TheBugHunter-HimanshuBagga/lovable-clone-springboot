package com.HimanshuBagga.projects.lovable_clone_springboot.entity;

import com.HimanshuBagga.projects.lovable_clone_springboot.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId id; // This works as a primary key in this project and helps us get the row by passing the projectId & userId

    @ManyToOne // Many projectMembers In One Project
    @MapsId("projectId")
    Project project;

    @ManyToOne // Many projectMembers In One Project
    @MapsId("userId")
    User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
