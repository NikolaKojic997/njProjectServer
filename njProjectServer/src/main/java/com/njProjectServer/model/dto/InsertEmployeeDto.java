package com.njProjectServer.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class InsertEmployeeDto {

    @NotEmpty(message = "Name field cannot be empty!")
    private String name;
    @NotEmpty(message = "Surname field cannot be empty!")
    private String surname;
    @NotNull (message = "Date cannot be null!")
    @Past (message = "Date must be in the past!")
    private Date employmentDate;

    @Length(min = 13, max = 13, message = "Length of id must be 13!")
    @Pattern(regexp = "^[0-9]*$", message = "invalid format of identification number")
    private String identificationNumber;

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
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
