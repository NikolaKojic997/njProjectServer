package com.njProjectServer.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

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
    @JsonProperty("nesto")
    private String nesto;

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

    public String getNesto() {
        return nesto;
    }

    public void setNesto(String nesto) {
        this.nesto = nesto;
    }
}
