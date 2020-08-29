package com.njProjectServer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "employeeId")
@DiscriminatorValue("A")
public class Assistant extends Employee {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "titleID")
    private Title title;

    public Assistant(String name, String surname, Date employmentDate, Title t, String identificationNumber) {
        super(name, surname, employmentDate, identificationNumber);
        this.title = t;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Assistant() {
    }
}
