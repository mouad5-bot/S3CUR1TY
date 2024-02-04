package com.example.security.factory;


import com.example.security.domain.AppPermission;
import com.example.security.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PermissionFactory {
    private final PermissionRepository permissionRepository;

    public List<AppPermission> createPermissionFactory(){
        List<AppPermission> appPermissionList = List.of(
                new AppPermission(null, "CREATE"),
                new AppPermission(null, "SHOW"),
                new AppPermission(null, "DELETE"),
                new AppPermission(null, "UPDATE"),
                new AppPermission(null, "ASSIGN"),
                new AppPermission(null, "ASSIGNTOOTHER"),
                new AppPermission(null, "REQUEST")
        );
        for (AppPermission permission : appPermissionList) {
            Optional<AppPermission> existingRole = permissionRepository.findByName(permission.getName());
            if (existingRole.isEmpty()) {
                try {
                    permissionRepository.save(permission);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return appPermissionList ;
    }
}
