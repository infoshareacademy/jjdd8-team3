package com.infoshare.academy.highfive.dto.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.Team;

import javax.persistence.Column;
import java.time.LocalDate;

public class EmployeeView {

  private Long id;

  @JsonProperty("first_name")
  private String firstName;

  private String surname;

  @JsonProperty("hire_date")
  private LocalDate hireDate;

  @JsonProperty("holiday_entitlement")
  private Integer holidayEntitlement;

  @JsonProperty("additional_entitlement")
  private Integer additionalEntitlement;

  @JsonProperty("email")
  private String email;

  @JsonProperty("team_id")
  private TeamView teamView;

  @JsonProperty("role_id")
  private Role role;

  public EmployeeView(){};

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public void setHireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
  }

  public Integer getHolidayEntitlement() {
    return holidayEntitlement;
  }

  public void setHolidayEntitlement(Integer holidayEntitlement) {
    this.holidayEntitlement = holidayEntitlement;
  }

  public Integer getAdditionalEntitlement() {
    return additionalEntitlement;
  }

  public void setAdditionalEntitlement(Integer additionalEntitlement) {
    this.additionalEntitlement = additionalEntitlement;
  }

  public TeamView getTeamView() {
    return teamView;
  }

  public void setTeamView(TeamView teamView) {
    this.teamView = teamView;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
