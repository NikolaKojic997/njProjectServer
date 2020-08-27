package com.njProjectServer.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class InsertEmployeeDto {

    @NotEmpty(message = "Name field cannot be empty!")
    private String name;
    @NotEmpty(message = "Surname field cannot be empty!")
    private String surname;
    @NotNull (message = "Date cannot be null!")
    @Past (message = "Date must be in the past!")
    private Date employmentDate;

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
