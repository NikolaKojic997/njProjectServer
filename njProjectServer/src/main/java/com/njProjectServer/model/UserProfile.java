package com.njProjectServer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class UserProfile {
    @Id @GeneratedValue
    private int profileID;
    private String username;
    private String password;
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId", nullable = false)
    @JsonIgnoreProperties("profiles")
    private Employee employee;

    public int getProfileId() {
        return profileID;
    }

    public void setProfileId(int userId) {
        this.profileID = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public UserProfile(String username, String password, String email, Employee employee) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.employee = employee;
    }
}
