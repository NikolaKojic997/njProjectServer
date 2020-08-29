package com.njProjectServer.model.dto;
import javax.validation.constraints.*;

public class InsertTeacherDto extends InsertEmployeeDto {


    @Min(value = 0, message = "RankID must be positive number")
    private int rankID;

    @Min(value = 0, message = "TitleID must be positive number")
    private int titleID;

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public int getTitleID() {
        return titleID;
    }

    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }
}
