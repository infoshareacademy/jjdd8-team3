package com.infoshare.academy.highfive.employeemanager;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("employees")
public class Team {

    @JsonAlias({"teamId", "team_id"})
    @JsonProperty("team_id")
    private Integer teamId;

    @JsonAlias({"teamName", "team_name"})
    @JsonProperty("team_name")
    private String teamName;

    public Team() {
    }

    public Team(Integer teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

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

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                '}';
    }
}
