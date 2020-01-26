package com.infoshare.academy.highfive.dto.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.domain.Team;

import java.time.LocalDate;

public class EmployeeView {

  private Long Id;

  @JsonProperty("first_name")
  private String firstName;

  private String surname;

  @JsonProperty("hire_date")
  private LocalDate hireDate;

  @JsonProperty("holiday_entitlement")
  private int holidayEntitlement;

  @JsonProperty("additional_entitlement")
  private int additionalEntitlement;

  @JsonProperty("team_id")
  private Team teamId;

  @JsonProperty("role_id")
  private Role roleId;

//  public EmployeeView(Long Id, String firstName, String surname, LocalDate hireDate, int holidayEntitlement, int additionalEntitlement, Team teamId, Role roleId) {
//    this.Id = Id;
//    this.firstName = firstName;
//    this.surname = surname;
//    this.hireDate = hireDate;
//    this.holidayEntitlement = holidayEntitlement;
//    this.additionalEntitlement = additionalEntitlement;
//    this.teamId = teamId;
//    this.roleId = roleId;
//  }

  public Long getId() {
    return Id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSurname() {
    return surname;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public int getHolidayEntitlement() {
    return holidayEntitlement;
  }

  public int getAdditionalEntitlement() {
    return additionalEntitlement;
  }

  public Team getTeamId() {
    return teamId;
  }

  public Role getRoleId() {
    return roleId;
  }

  public void setId(Long id) { Id = id; }

  public void setFirstName(String firstName) { this.firstName = firstName; }

  public void setSurname(String surname) { this.surname = surname; }

  public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

  public void setHolidayEntitlement(int holidayEntitlement) { this.holidayEntitlement = holidayEntitlement; }

  public void setAdditionalEntitlement(int additionalEntitlement) { this.additionalEntitlement = additionalEntitlement; }

  public void setTeamId(Team teamId) { this.teamId = teamId; }

  public void setRoleId(Role roleId) { this.roleId = roleId; }
}
