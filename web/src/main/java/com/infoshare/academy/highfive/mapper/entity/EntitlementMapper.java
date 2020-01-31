package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Entitlement;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;

@RequestScoped
public class EntitlementMapper {

    @Inject
    private EmployeeDao employeeDao;

    public Entitlement mapRequestToEntity(EmployeeRequest request) {

        Entitlement entitlement = new Entitlement();

        return mapRequestToEntity(request, entitlement);
    }

    public Entitlement mapRequestToEntity(EmployeeRequest request, Entitlement entitlement){

        Employee employee = employeeDao.getByEmail(request.getEmail());

        entitlement.setVacationLeft(request.getHolidayEntitlement());
        entitlement.setVacationTaken(request.getAdditionalEntitlement());
        entitlement.setPreviousYearLeft(0);
        entitlement.setCurrentDate(LocalDate.now());
        entitlement.setOnDemandVacationLeft(4);
        entitlement.setEmployee(employee);

        return entitlement;
    }
}
