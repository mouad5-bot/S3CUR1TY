package com.simplon.springsecurty.security.auth;

import com.simplon.springsecurty.entities.AppUser;
import com.simplon.springsecurty.security.auth.JwtAuthenticationResponse;
import com.simplon.springsecurty.web.dto.SignInRequest;
import com.simplon.springsecurty.web.dto.SignUpRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);

    JwtAuthenticationResponse refreshToken(String refreshToken);

    AppUser me();
}