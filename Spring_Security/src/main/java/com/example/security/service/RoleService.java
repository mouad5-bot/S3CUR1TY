package com.example.security.service;

import com.example.security.domain.AppRole;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    AppRole FindByName(String name ) ;
}
