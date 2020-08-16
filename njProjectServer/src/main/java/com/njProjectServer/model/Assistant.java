package com.njProjectServer.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "employeeId")
public class Assistant extends Employee {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "titleID")
    private Title title;
}
