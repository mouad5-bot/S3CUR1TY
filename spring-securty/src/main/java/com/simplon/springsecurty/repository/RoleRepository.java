package com.simplon.springsecurty.repository;

import com.simplon.springsecurty.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(String roleName);
    Optional<Role> findByName(String role);
}
