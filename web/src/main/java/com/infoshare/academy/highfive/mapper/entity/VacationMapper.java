package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.dto.view.VacationCalendarView;
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
    vacationEntity.setReminderEmailSent(vacationRequest.getReminderEmailSent());

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

  public VacationSSE mapEntityToSSE(VacationView vacationView) {

    VacationSSE vacationSSE = new VacationSSE();
    vacationSSE.setId(vacationView.getId());
    vacationSSE.setFirstName(vacationView.getFirstName());
    vacationSSE.setSurname(vacationView.getSurname());
    vacationSSE.setVacationStatus(vacationView.getVacationStatus());
    vacationSSE.setDateOfRequest(vacationView.getDateOfRequest());
    vacationSSE.setDateOfRequestIso((vacationView.getDateOfRequest().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).substring(0, 19) + "Z");

    return vacationSSE;
  }

  public VacationCalendarView mapEntityToViewDates(Vacation vacationEntity) {

    VacationCalendarView vacationCalendarView = new VacationCalendarView();

    vacationCalendarView.setEmployeeId(vacationEntity.getEmployee().getId());
    vacationCalendarView.setFirstName(vacationEntity.getEmployee().getFirstName());
    vacationCalendarView.setSurname(vacationEntity.getEmployee().getSurname());
    vacationCalendarView.setVacationFrom(vacationEntity.getVacationFrom());
    vacationCalendarView.setVacationTo(vacationEntity.getVacationTo());
    vacationCalendarView.setVacationStatus(vacationEntity.getVacationStatus());
    vacationCalendarView.setVacationType(vacationEntity.getVacationType());
    vacationCalendarView.setYearFrom(vacationEntity.getVacationFrom().getYear());
    vacationCalendarView.setMonthFrom(vacationEntity.getVacationFrom().getMonthValue());
    vacationCalendarView.setDayFrom(vacationEntity.getVacationFrom().getDayOfMonth());
    vacationCalendarView.setYearTo(vacationEntity.getVacationTo().getYear());
    vacationCalendarView.setMonthTo(vacationEntity.getVacationTo().getMonthValue());
    vacationCalendarView.setDayTo(vacationEntity.getVacationTo().getDayOfMonth());

    return vacationCalendarView;

  }

}
