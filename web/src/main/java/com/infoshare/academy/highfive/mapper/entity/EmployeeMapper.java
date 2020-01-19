package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.request.EmployeeRequest;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EmployeeMapper {

    public Employee mapRequestToEntity(EmployeeRequest request) {

        Employee employee = new Employee();


        employee.setFirstName(request.getFirstName());
        employee.setSurname(request.getSurname());
        employee.setHireDate(request.getHireDate());
        employee.setHolidayEntitlement(request.getHolidayEntitlement());
        employee.setAdditionalEntitlement(request.getAdditionalEntitlement());
        employee.setEmail(request.getEmail());
        employee.setLogin(request.getLogin());
        employee.setPosition(request.getPosition());
        employee.setTeam(request.getTeam());
        employee.setRole(request.getRole());

        return employee;
    }
}
