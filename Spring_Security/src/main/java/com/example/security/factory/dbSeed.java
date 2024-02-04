package com.example.security.factory;
import com.example.security.domain.AppPermission;
import com.example.security.domain.AppRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class dbSeed {
    private  final RoleFactory roleFactory ;
    private  final PermissionFactory permissionFactory ;
    @Bean
    CommandLineRunner start(){
        return args -> {
                List<AppRole> appRoleList = roleFactory.createRoles();
                List<AppPermission> appPermissionList = permissionFactory.createPermissionFactory();
        };
    }
}
