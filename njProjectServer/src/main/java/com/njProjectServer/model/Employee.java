package com.njProjectServer.model;

import org.hibernate.Incubating;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table()
public class Employee {
    @Id
    private int employeeId;
    private String name;
    private String surname;
    private Date employmentDate;

    @OneToMany()
    @JoinColumn(name = "employeeId")
    private List<UserProfile> prifiles;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<UserProfile> getPrifiles() {
        return prifiles;
    }

    public void setPrifiles(List<UserProfile> prifiles) {
        this.prifiles = prifiles;
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
}
