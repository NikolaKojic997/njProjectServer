package com.njProjectServer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rank {
    @Id
    private int rankID;
    private String rankName;

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }
}
