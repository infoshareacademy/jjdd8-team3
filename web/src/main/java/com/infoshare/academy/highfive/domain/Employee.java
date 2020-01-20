package com.infoshare.academy.highfive.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "holiday_entitlement", nullable = false)
    private Integer holidayEntitlement;

    @Column(name = "additional_entitlement")
    private Integer additionalEntitlement;

    @Column(name = "login")
    private String login;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "position")
    private String position;

    @JoinColumn(name = "team_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getHolidayEntitlement() { return holidayEntitlement; }

    public void setHolidayEntitlement(Integer holidayEntitlement) {
        this.holidayEntitlement = holidayEntitlement;
    }

    public int getAdditionalEntitlement() {
        return additionalEntitlement;
    }

    public void setAdditionalEntitlement(Integer additionalEntitlement) {
        this.additionalEntitlement = additionalEntitlement; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }


    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }
}
