package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.dto.view.VacationView;

import javax.ejb.Stateless;

@Stateless
public class VacationMapper {

  public Vacation mapRequestToEntity(Employee employee, VacationRequest vacationRequest) {

    Vacation vacationEntity = new Vacation();
    vacationEntity.setEmployee(employee);
    vacationEntity.setVacationFrom(vacationRequest.getDateFrom());
    vacationEntity.setVacationTo(vacationRequest.getDateTo());
    vacationEntity.setVacationType(vacationRequest.getVacationType());
    vacationEntity.setVacationStatus(vacationRequest.getVacationStatus());

    return vacationEntity;

  }

  public VacationView mapEntityToView(Vacation vacationEntity) {

    VacationView vacationView = new VacationView();
    vacationView.setId(vacationEntity.getId());
    vacationView.setEmployeeId(vacationEntity.getEmployee().getId());
    vacationView.setFirstName(vacationEntity.getEmployee().getFirstName());
    vacationView.setSurname(vacationEntity.getEmployee().getSurname());
    vacationView.setPosition(vacationEntity.getEmployee().getPosition());
    vacationView.setVacationFrom(vacationEntity.getVacationFrom());
    vacationView.setVacationTo(vacationEntity.getVacationTo());
    vacationView.setDateOfRequest(vacationEntity.getDateOfRequest());
    vacationView.setVacationType(vacationEntity.getVacationType());
    vacationView.setVacationStatus(vacationEntity.getVacationStatus());

    return vacationView;
  }

}
