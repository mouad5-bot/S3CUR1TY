package com.example.security.service.impl;

import com.example.security.domain.AppRole;
import com.example.security.repository.RoleRepository;
import com.example.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository ;
    @Override
    public AppRole FindByName(String name) {
       return roleRepository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("No Role with this name"));
    }
}
