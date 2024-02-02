package com.simplon.springsecurty.service;

import com.simplon.springsecurty.entities.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {

    AppUser save (AppUser user);

    List<AppUser> findAll();

    Optional<AppUser> findByEmail(String email);

    UserDetailsService userDetailsService();

    public AppUser getCurrentUser();

    void delete(Long id);
}
