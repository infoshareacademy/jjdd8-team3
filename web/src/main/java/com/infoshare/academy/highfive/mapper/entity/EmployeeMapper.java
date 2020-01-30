package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.dao.TeamDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.dto.view.EmployeeView;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EmployeeMapper {

    @Inject
    private TeamMapper teamMapper;

    @Inject
    private TeamDao teamDao;

    public EmployeeView mapEntityToView(Employee employee) {

        EmployeeView employeeView = new EmployeeView();

        if (employee == null) {
            return employeeView;
        }

        employeeView.setId(employee.getId());
        employeeView.setFirstName(employee.getFirstName());
        employeeView.setSurname(employee.getSurname());
        employeeView.setEmail(employee.getEmail());
        employeeView.setPosition(employee.getPosition());
        employeeView.setTeam(teamMapper.mapEntityToView(employee.getTeam()));
        employeeView.setHireDate(employee.getHireDate());
        employeeView.setHolidayEntitlement(employee.getHolidayEntitlement());
        employeeView.setAdditionalEntitlement(employee.getAdditionalEntitlement());
        employeeView.setRole(employee.getRole());

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
        employee.setTeam(teamDao.getById(request.getTeam()).orElse(null));
        employee.setRole(request.getRole());

        return employee;
    }
}
