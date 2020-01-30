package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Entitlement;
import com.infoshare.academy.highfive.dto.view.VacationEmployeeView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class VacationEmployeeMapper {

  public VacationEmployeeView mapEntityToView(Entitlement entitlement) {

    VacationEmployeeView vacationEmployeeView = new VacationEmployeeView();

    vacationEmployeeView.setFirstName(entitlement.getEmployee().getFirstName());
    vacationEmployeeView.setId(entitlement.getEmployee().getId());
    vacationEmployeeView.setSecondName(entitlement.getEmployee().getSurname());
    vacationEmployeeView.setVacationTaken(entitlement.getVacationTaken());

    return vacationEmployeeView;

  }

}
