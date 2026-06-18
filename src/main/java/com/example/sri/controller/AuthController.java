
package com.example.sri.controller;
import com.example.sri.dto.AuthResponse;
import com.example.sri.dto.LoginRequest;
import com.example.sri.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        log.info("Login request received for kn  user: {}",
                request.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        log.info("Authentication successful for user: {}",
                request.getUsername());

        String token = jwtService.generateToken(
                request.getUsername()
        );

        log.info("JWT token generated for user: {}",
                request.getUsername());

        return new AuthResponse(token);
    }
}