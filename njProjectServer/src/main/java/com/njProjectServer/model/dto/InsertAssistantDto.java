package com.njProjectServer.model.dto;

import javax.validation.constraints.Min;

public class InsertAssistantDto extends InsertTeacherDto {
    @Min(value = 0, message = "Title id must be positive number!")
    private int titleID;

    @Override
    public int getTitleID() {
        return titleID;
    }

    @Override
    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }
}
