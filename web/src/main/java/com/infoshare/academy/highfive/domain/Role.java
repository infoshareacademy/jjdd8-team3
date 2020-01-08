package com.infoshare.academy.highfive.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(
            mappedBy = "teamId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("surname asc")
    private Set<Employee> roleEmployeeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Employee> getRoleEmployeeList() {
        return roleEmployeeList;
    }

    public void setRoleEmployeeList(Set<Employee> roleEmployeeList) {
        this.roleEmployeeList = roleEmployeeList;
    }
}
