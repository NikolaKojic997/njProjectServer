package com.njProjectServer.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "employeeId")
public class Teacher extends Employee {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rankID", nullable = false)
    private Rank rank;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "titleID", nullable = false)
    private Title title;

}
