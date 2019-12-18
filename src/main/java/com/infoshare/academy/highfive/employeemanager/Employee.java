package com.infoshare.academy.highfive.employeemanager;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.infoshare.academy.highfive.tool.CustomEmployeeDeserializer;
import com.infoshare.academy.highfive.tool.ParseStringToIsoDate;

import java.time.LocalDate;

@JsonDeserialize(using = CustomEmployeeDeserializer.class)
public class Employee {

    @JsonProperty("employee_id")
    private Integer employeeId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("hire_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @JsonProperty("holiday_entitlement")
    private Integer holidayEntitlement;

    @JsonProperty("additional_entitlement")
    private Integer additionalEntitlement;

    @JsonProperty("team")
    private Team teamName;

    public Employee() {
    }

    public Employee(Integer employeeId, String firstName, String surname, LocalDate hireDate, Integer holidayEntitlement, Integer additionalEntitlement, Team teamName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.surname = surname;
        this.hireDate = hireDate;
        this.holidayEntitlement = holidayEntitlement;
        this.additionalEntitlement = additionalEntitlement;
        this.teamName = teamName;
    }


    Integer getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    String getSurname() {
        return surname;
    }

    public Employee setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Employee setHireDate(String hireDate) {
        this.hireDate = ParseStringToIsoDate.parseStringToDate(hireDate);
        return this;
    }

    public Integer getHolidayEntitlement() {
        return holidayEntitlement;
    }

    public Employee setHolidayEntitlement(Integer holidayEntitlement) {
        this.holidayEntitlement = holidayEntitlement;
        return this;
    }

    public Integer getAdditionalEntitlement() {
        return additionalEntitlement;
    }

    public Employee setAdditionalEntitlement(Integer additionalEntitlement) {
        this.additionalEntitlement = additionalEntitlement;
        return this;
    }

    Team getTeamName() {
        return teamName;
    }

    public void setTeamName(Team teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return  "Id. " + employeeId +
                ", " + firstName + " " + surname  +
                ", team: " + teamName.getTeamName() +
                ", hire date: " + hireDate +
                ", holiday entitlement: " + holidayEntitlement +
                ", additional entitlement: " + additionalEntitlement +
                "\n";
    }

}
