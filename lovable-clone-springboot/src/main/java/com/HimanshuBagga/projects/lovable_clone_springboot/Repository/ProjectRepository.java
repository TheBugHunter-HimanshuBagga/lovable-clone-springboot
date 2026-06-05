package com.HimanshuBagga.projects.lovable_clone_springboot.Repository;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.ProjectRequest;
import com.HimanshuBagga.projects.lovable_clone_springboot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project , Long> {

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC
            """
    )
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    @Query("""
            SELECT p FROM Project p
            LEFT JOIN FETCH p.owner
            WHERE p.id = :projectId
                AND p.deletedAt IS NULL
                AND p.owner.id = :userId
            """)
    Project findAccessibleProjectById(@Param("projectId") Long projectId,
                                                @Param("userId") Long userId);

}

/*
This above is the custom query here
We define our own JPQL here and it is then converted to the raw sql by Hibernate
 */
