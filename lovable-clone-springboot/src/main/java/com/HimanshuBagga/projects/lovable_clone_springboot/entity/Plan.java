package com.HimanshuBagga.projects.lovable_clone_springboot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {
    Long id;
    String name;
    String stripePriceId;
    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews; // max number of previews allowed per plan
    Boolean unlimitedAi; // unlimited access to AI without maxTokensPerDay
    Boolean active;
}
