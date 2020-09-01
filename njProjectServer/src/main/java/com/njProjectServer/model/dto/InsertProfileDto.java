package com.njProjectServer.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.njProjectServer.model.Employee;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
    @NotEmpty(message = "Identification number cannot be empty")
    @Length(min = 13, max = 13, message = "Length of id must be 13!")
    @Pattern(regexp = "^[0-9]*$", message = "invalid format of identification number")
    private String identificationNumber;

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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
