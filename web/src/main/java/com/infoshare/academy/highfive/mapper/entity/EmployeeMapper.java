package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.dto.view.EmployeeView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EmployeeMapper {

    public EmployeeView mapEntityToView(Employee employee){

        EmployeeView employeeView = new EmployeeView();

        if (employee == null) { return employeeView; }

        employeeView.setId(employee.getId());
        employeeView.setFirstName(employee.getFirstName());
        employeeView.setSurname(employee.getSurname());

        return employeeView;
    }

//for save
    public Employee mapRequestToEntity(EmployeeRequest request) {

        Employee employee = new Employee();

        return mapRequestToEntity(request, employee);
    }

//for update
    public Employee mapRequestToEntity(EmployeeRequest request, Employee employee) {

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
