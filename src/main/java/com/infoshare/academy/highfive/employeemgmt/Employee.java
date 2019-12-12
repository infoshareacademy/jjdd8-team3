package com.infoshare.academy.highfive.employeemgmt;

public class Employee {
    private Integer employeeId;
    private String firstName;
    private String surname;
    private String hireDate;
    private Integer holidayEntitlement;
    private Integer additionalEntitlement;
    private Team teamName;

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

    public String getHireDate() {
        return hireDate;
    }

    public Employee setHireDate(String hireDate) {
        this.hireDate = hireDate;
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
}
