package com.HimanshuBagga.projects.lovable_clone_springboot.Repository;

import com.HimanshuBagga.projects.lovable_clone_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
