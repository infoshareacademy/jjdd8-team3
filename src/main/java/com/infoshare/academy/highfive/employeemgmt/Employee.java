package com.infoshare.academy.highfive.employeemgmt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.infoshare.academy.highfive.tool.CustomEmployeeDeserializer;
import com.infoshare.academy.highfive.tool.ParseStringToIsoDate;

import java.time.LocalDate;

@JsonDeserialize(using = CustomEmployeeDeserializer.class)
public class Employee {
    //    @JsonAlias({"employeeId", "employee_id"})
    @JsonProperty("employee_id")
    private Integer employeeId;

    //   @JsonAlias({"firstName", "first_name"})
    @JsonProperty("first_name")
    private String firstName;

    //   @JsonAlias({"surname", "surname"})
    @JsonProperty("surname")
    private String surname;

    //   @JsonAlias({"hireDate", "hire_date"})
    @JsonProperty("hire_date")
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    //   @JsonAlias({"holidayEntitlement", "holiday_entitlement"})
    @JsonProperty("holiday_entitlement")
    private Integer holidayEntitlement;

    //  @JsonAlias({"additionalEntitlement", "additional_entitlement"})
    @JsonProperty("additional_entitlement")
    private Integer additionalEntitlement;

    //   @JsonAlias({"teamName", "team"})
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


    public Integer getEmployeeId() {
        return employeeId;
    }

    public Employee setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSurname() {
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

    public Team getTeamName() {
        return teamName;
    }


    public Employee setTeamName(Team teamName) {
        this.teamName = teamName;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", holidayEntitlement=" + holidayEntitlement +
                ", additionalEntitlement=" + additionalEntitlement +
                ", teamName=" + teamName.toString() +
                '}' + "\n";
    }
}
