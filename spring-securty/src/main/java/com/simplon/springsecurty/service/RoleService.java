package com.simplon.springsecurty.service;

import com.simplon.springsecurty.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String roleUser);

    Role save(Role role);
}
