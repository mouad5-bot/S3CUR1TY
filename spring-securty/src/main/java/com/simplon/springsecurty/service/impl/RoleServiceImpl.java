package com.simplon.springsecurty.service.impl;

import com.simplon.springsecurty.entities.Role;
import com.simplon.springsecurty.repository.RoleRepository;
import com.simplon.springsecurty.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRpository;
    @Override
    public Optional<Role> findByName(String role) {
        return roleRpository.findByName(role);
    }

    @Override
    public Role save(Role role) {
        String roleName = role.getName();
        if(roleRpository.existsByName(roleName))
            throw new RuntimeException("Role with name "+ roleName +" already exists");
        return roleRpository.save(role);
    }
}
