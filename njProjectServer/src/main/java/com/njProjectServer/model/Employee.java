package com.njProjectServer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        name = "type",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("E")
public class Employee  {
    @Id @GeneratedValue
    private int employeeId;
//    @NotEmpty(message = "Name field cannot be empty!")
    private String name;
//    @NotEmpty(message = "Surname field cannot be empty!")
    private String surname;
//    @NotNull @Past
    private Date employmentDate;

    @OneToMany()
    @JoinColumn(name = "employeeId")
    @JsonIgnoreProperties("employee")
    private List<UserProfile> profiles;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<UserProfile> profiles) {
        this.profiles = profiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Employee(String name, String surname, Date employmentDate) {
        this.name = name;
        this.surname = surname;
        this.employmentDate = employmentDate;
    }
}
