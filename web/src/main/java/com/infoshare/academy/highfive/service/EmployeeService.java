package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.mapper.entity.EmployeeMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class EmployeeService {

    @Inject
    private EmployeeMapper employeeMapper;
    @Inject
    private EmployeeDao employeeDao;
    @Inject
    private EntitlementDao entitlementDao;

    public void save(EmployeeRequest request) {
        employeeDao.save(employeeMapper.mapRequestToEntity(request));
    }

    public void update(Long id, EmployeeRequest request) {
        Employee employee = employeeDao.getById(id).orElseThrow();

        employeeMapper.mapRequestToEntity(request, employee);

        employeeDao.update(employee);
    }

    public EmployeeView remove(Long id) {
        return employeeMapper.mapEntityToView(employeeDao.delete(id));
    }

    public EmployeeView findById(Long id) {
        Employee employee = employeeDao.getById(id).orElseThrow();
        return this.employeeMapper.mapEntityToView(employee);
    }

    public int listAllSize() {
        return employeeDao.listAllEmployees().size();
    }

    public List<EmployeeView> listAll() {
        List<EmployeeView> allEmployeesView = new ArrayList<>();
        employeeDao.listAllEmployees()
                .forEach(e -> allEmployeesView.add(employeeMapper.mapEntityToView(e)));
        return allEmployeesView;
    }

    public Boolean employeeExist(String email) {
        return employeeDao.findByEmail(email).isPresent();
    }


    public Boolean isSuperAdmin(String email) {
        Optional<Employee> employee = employeeDao.findByEmail(email);

        return employee.map(value -> value.getRole()
                .equals(Role.ADMIN))  //Todo
                .orElse(false);
    }

    public Optional<EmployeeRequest> getEmployeeByEmail(String email) {
        return employeeDao.findByEmail(email).map(EmployeeMapper::mapEntityToRequest);
    }

}