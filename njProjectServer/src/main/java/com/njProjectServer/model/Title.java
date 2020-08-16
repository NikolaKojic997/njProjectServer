package com.njProjectServer.model;

import javax.persistence.*;

@Entity
public class Title {

    @Id
    private int titleID;
    private String titleName;
}
