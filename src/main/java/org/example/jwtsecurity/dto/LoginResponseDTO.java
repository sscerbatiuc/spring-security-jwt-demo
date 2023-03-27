package org.example.jwtsecurity.dto;

import java.io.Serializable;
public class LoginResponseDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String token;
    public LoginResponseDTO(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
