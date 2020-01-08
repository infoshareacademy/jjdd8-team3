package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="team_name", nullable = false)
    private String teamName;

    @OneToMany(
            mappedBy = "teamId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("surname asc")
    private Set<Employee> teamEmployeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
