package com.infoshare.academy.highfive.employeemgmt;

public class Team {
    private Integer teamId;
    private String teamName;

    public Integer getTeamId() {
        return teamId;
    }

    public Team setTeamId(Integer teamId) {
        this.teamId = teamId;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }
}
