package org.example.jwtsecurity.dto;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2636936156391265891L;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
