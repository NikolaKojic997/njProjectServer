package com.njProjectServer.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.njProjectServer.model.Employee;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class InsertProfileDto {
    @NotEmpty(message = "Username cannot be empty")

    private String username;
    @NotEmpty(message = "Password cannot be empty")
    //Some pw regular expression
    private String password;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "invalid email format!")
    private String email;
    @Positive(message = "EmployeeID must be positive")
    private int employeeID;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
