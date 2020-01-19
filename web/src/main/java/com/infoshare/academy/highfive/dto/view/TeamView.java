package com.infoshare.academy.highfive.dto.view;

import com.infoshare.academy.highfive.domain.Employee;

import javax.persistence.*;
import java.util.Set;

public class TeamView {

    private Long id;

    private String teamName;

    private Set<Employee> teamEmployeeList;

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

    public Set<Employee> getTeamEmployeeList() {
        return teamEmployeeList;
    }

    public void setTeamEmployeeList(Set<Employee> teamEmployeeList) {
        this.teamEmployeeList = teamEmployeeList;
    }
}
