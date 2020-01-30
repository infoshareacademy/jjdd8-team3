package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.mapper.entity.EmployeeMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmployeeService {

    @Inject
    private EmployeeMapper employeeMapper;

    @Inject
    private EmployeeDao employeeDao;

    public void addNewEmployee(EmployeeRequest request) {
        employeeDao.addEmployee(employeeMapper.mapRequestToEntity(request));
    }

    public void editEmployee(EmployeeRequest request) {
        employeeDao.editEmployee(employeeMapper.mapRequestToEntity(request));
    }

    public void deleteEmployee(EmployeeRequest request) {
        employeeDao.deleteEmployee(employeeMapper.mapRequestToEntity(request));
    }

    public Employee getById(Long id) {
        return this.employeeDao.getEmployeeById(id);
    }

    public Boolean employeeExist(String email){
        return employeeDao.findByEmail(email).isPresent();
    }
}
