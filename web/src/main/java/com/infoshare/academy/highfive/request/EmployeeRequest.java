package com.infoshare.academy.highfive.request;

import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.Team;
import java.util.Date;

public class EmployeeRequest {

    private Long id;

    private String firstName;

    private String surname;

    private Date hireDate;

    private Integer holidayEntitlement;

    private  Integer additionalEntitlement;

    private String login;

    private String email;

    private String position;

    private Team team;

    private Role role;

    public Long getId() { return id;  }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public Date getHireDate() { return hireDate; }

    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public Integer getHolidayEntitlement() { return holidayEntitlement; }

    public void setHolidayEntitlement(Integer holidayEntitlement) { this.holidayEntitlement = holidayEntitlement; }

    public Integer getAdditionalEntitlement() { return additionalEntitlement; }

    public void setAdditionalEntitlement(Integer additionalEntitlement) { this.additionalEntitlement = additionalEntitlement; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public Team getTeam() { return team; }

    public void setTeam(Team teamId) { this.team = teamId; }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }
}