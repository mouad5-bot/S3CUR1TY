package com.example.security.factory;

import com.example.security.domain.AppRole;
import com.example.security.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleFactory {
    private final RoleRepository roleRepository;

    @Transactional
    public List<AppRole> createRoles() {
        List<AppRole> appRoleList = List.of(
                AppRole.builder().name("ROLE_USER").build(),
                AppRole.builder().name("ROLE_ADMIN").build()
        );

        for (AppRole role : appRoleList) {
            Optional<AppRole> existingRole = roleRepository.findByName(role.getName());
            if (existingRole.isEmpty()) {
                try {
                    roleRepository.save(role);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return appRoleList;
    }
}
