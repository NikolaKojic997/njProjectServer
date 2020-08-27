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

    public Assistant(String name, String surname, Date employmentDate) {
        super(name, surname, employmentDate);
    }
}
