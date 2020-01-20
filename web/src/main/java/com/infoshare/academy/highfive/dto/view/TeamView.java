package com.infoshare.academy.highfive.dto.view;

import com.infoshare.academy.highfive.domain.Employee;

import java.util.List;

public class TeamView {

    private Long id;

    private String teamName;

    private List<Employee> teamMembers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
