package com.infoshare.academy.highfive.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamRequest {

    private Long id;

    @JsonProperty("team_name")
    private String teamName;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTeamName() { return teamName; }

    public void setTeamName(String teamName) { this.teamName = teamName; }
}
