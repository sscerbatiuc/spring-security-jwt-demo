package org.example.jwtsecurity.controller;

import org.example.jwtsecurity.dto.LoginDTO;
import org.example.jwtsecurity.dto.LoginResponseDTO;
import org.example.jwtsecurity.configuration.JwtTokenService;
import org.example.jwtsecurity.dto.RegistrationDTO;
import org.example.jwtsecurity.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SecurityController {
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    @Autowired
    public SecurityController(UserDetailsServiceImpl userDetailsService, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> createToken(@RequestBody LoginDTO request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("User disabled", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = jwtTokenService.generateJwtToken(userDetails);
        return ResponseEntity.ok(new LoginResponseDTO(jwtToken));
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> createToken(@RequestBody RegistrationDTO request) {

        userDetailsService.save(request.getUsername(), request.getPassword());
        return ResponseEntity.ok().build();
    }
}
