package com.njProjectServer.model;

import javax.persistence.*;

@Entity
public class Title {

    @Id
    private int titleID;
    private String titleName;

    public int getTitleID() {
        return titleID;
    }

    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
