package com.njProjectServer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rank {
    @Id
    private int rankID;
    private String rankName;
}
