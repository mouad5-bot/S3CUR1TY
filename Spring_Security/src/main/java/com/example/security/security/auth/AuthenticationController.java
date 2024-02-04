package com.example.security.security.auth;

import com.example.security.exception.UnauthorizedException;
import com.example.security.web.dto.LoginRequest;
import com.example.security.web.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest login) {
        JwtAuthenticationResponse result = authenticationService.login(login);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody @Valid RegisterRequest register) throws ValidationException, Exception {
        JwtAuthenticationResponse result = authenticationService.register(register);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/token/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(HttpServletRequest request) throws ValidationException, com.example.security.utils.ValidationException {
        String authorization = request.getHeader("Authorization");
        if(authorization == null || !authorization.startsWith("Bearer ")) {
            throw new UnauthorizedException("Refresh token is missing");
        }
        String token = authorization.substring(7);
        JwtAuthenticationResponse result = authenticationService.refreshToken(token);
        return ResponseEntity.ok(result);
    }

}
