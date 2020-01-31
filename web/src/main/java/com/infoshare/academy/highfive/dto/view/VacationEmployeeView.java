package com.infoshare.academy.highfive.dto.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class VacationEmployeeView {

  private long id;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("second_name")
  private String secondName;

  @JsonProperty("vacation_taken")
  private int vacationTaken;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public int getVacationTaken() {
    return vacationTaken;
  }

  public void setVacationTaken(int vacationTaken) {
    this.vacationTaken = vacationTaken;
  }

}
