package com.njProjectServer.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "employeeId")
@DiscriminatorValue("T")
public class Teacher extends Employee {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rankID", nullable = false)
    @JsonProperty("rank")
    private Rank rank;
    @ManyToOne
    @JoinColumn(name = "titleID", nullable = false)
    @JsonProperty(value = "title")
    private Title title;

    public Teacher(String name, String surname, Date employmentDate, Title t, Rank r) {
        super(name, surname, employmentDate);
        this.rank = r;
        this.title = t;
    }



    @JsonGetter("rank")
    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @JsonGetter("title")
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Teacher() {
    }
}
