package com.example.security.repository;

import com.example.security.domain.AppPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<AppPermission, Long> {
    @Query("SELECT p FROM AppPermission p WHERE p.name = :name")
    Optional<AppPermission> findByName(@Param("name") String name);
}
