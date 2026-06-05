package com.HimanshuBagga.projects.lovable_clone_springboot.Repository;

import com.HimanshuBagga.projects.lovable_clone_springboot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project , Long> {

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC
            """
    )
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);
}

/*
This above is the custom query here
We define our own JPQL here and it is then converted to the raw sql by Hibernate
 */
