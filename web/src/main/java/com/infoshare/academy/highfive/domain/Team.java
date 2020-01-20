package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = "Team.findAll", query = "SELECT team " +
            "FROM Team team "),
        @NamedQuery (name = "Team.findAllTeamMembers", query = "SELECT employee " +
            "FROM Employee employee " +
            "WHERE Team.id = :teamId")
        }
        )

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", orphanRemoval = true )
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
