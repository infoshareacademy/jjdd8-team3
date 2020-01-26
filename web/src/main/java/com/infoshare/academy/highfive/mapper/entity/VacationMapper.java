package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.dto.view.VacationSSE;
import com.infoshare.academy.highfive.dto.view.VacationView;

import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Stateless
public class VacationMapper {

  public Vacation mapRequestToEntity(Employee employee, VacationRequest vacationRequest) {

    Vacation vacationEntity = new Vacation();
    vacationEntity.setEmployee(employee);
    vacationEntity.setVacationFrom(vacationRequest.getDateFrom());
    vacationEntity.setVacationTo(vacationRequest.getDateTo());
    vacationEntity.setVacationType(vacationRequest.getVacationType());
    vacationEntity.setVacationStatus(vacationRequest.getVacationStatus());
    vacationEntity.setDateOfRequest(LocalDateTime.now());

    return vacationEntity;

  }

  public VacationView mapEntityToView(Vacation vacationEntity) {

    VacationView vacationView = new VacationView();
    vacationView.setId(vacationEntity.getId());
    vacationView.setEmployeeId(vacationEntity.getEmployee().getId());
    vacationView.setFirstName(vacationEntity.getEmployee().getFirstName());
    vacationView.setSurname(vacationEntity.getEmployee().getSurname());
    vacationView.setEmail(vacationEntity.getEmployee().getEmail());
    vacationView.setPosition(vacationEntity.getEmployee().getPosition());
    vacationView.setVacationFrom(vacationEntity.getVacationFrom());
    vacationView.setVacationTo(vacationEntity.getVacationTo());
    vacationView.setDateOfRequest(vacationEntity.getDateOfRequest());
    vacationView.setVacationType(vacationEntity.getVacationType());
    vacationView.setVacationStatus(vacationEntity.getVacationStatus());

    return vacationView;
  }

  public VacationSSE mapEntityToSSE(Vacation vacationEntity) {

    VacationSSE vacationSSE = new VacationSSE();
    vacationSSE.setId(vacationEntity.getId());
    vacationSSE.setEmployeeId(vacationEntity.getEmployee().getId());
    vacationSSE.setFirstName(vacationEntity.getEmployee().getFirstName());
    vacationSSE.setSurname(vacationEntity.getEmployee().getSurname());
    vacationSSE.setVacationStatus(vacationEntity.getVacationStatus());
    VacationSSE.setDateOfRequest(vacationEntity.getDateOfRequest());
    //vacationSSE.setDateOfRequestIso(vacationEntity.getDateOfRequest().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    vacationSSE.setDateOfRequestIso((vacationEntity.getDateOfRequest().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).substring(0,19)+"Z");

    return vacationSSE;
  }

}
