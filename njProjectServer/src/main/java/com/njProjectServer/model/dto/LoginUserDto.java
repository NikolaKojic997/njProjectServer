package com.njProjectServer.model.dto;

import javax.validation.constraints.NotEmpty;

public class LoginUserDto {
    @NotEmpty(message = "Username cannot be empty")
    String username;
    @NotEmpty(message = "Password cannot be empty")
    String password;

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
}
