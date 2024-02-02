package com.simplon.springsecurty.service.impl;

import com.simplon.springsecurty.entities.AppUser;
import com.simplon.springsecurty.repository.UserRepository;
import com.simplon.springsecurty.service.UserService;
import com.simplon.springsecurty.utils.SecurityUtils;
import com.simplon.springsecurty.web.exception.EmailAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public AppUser save(AppUser user) {
        findByEmail(user.getEmail()).ifPresent(u -> {
            throw new EmailAlreadyExistException();
        });
        return userRepository.save(user);
    }

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found by username: " + username));
    }

    @Override
    public AppUser getCurrentUser() {
        String currentUserLogin = SecurityUtils.getCurrentUserLogin();
        if(currentUserLogin == null)
            throw new BadCredentialsException("User not found");
        return this.findByEmail(currentUserLogin).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
