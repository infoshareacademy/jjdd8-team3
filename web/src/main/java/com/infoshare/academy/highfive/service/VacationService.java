package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.dao.VacationDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.VacationType;
import com.infoshare.academy.highfive.mapper.request.EmployeeMapper;
import com.infoshare.academy.highfive.mapper.request.VacationMapper;
import com.infoshare.academy.highfive.request.VacationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class VacationService {

  @Inject
  EmployeeDao employeeDao;

  @Inject
  HolidayDao holidayDao;

  @Inject
  VacationDao vacationDao;

  @Inject
  VacationMapper vacationMapper;

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  public void addVacation(VacationRequest vacationRequest) {

    Employee employee = employeeDao.getEmployeeById(vacationRequest.getEmployeeId());

    int entitlement = getEmployeeEntitlement(employee, vacationRequest);
    int daysOff = calculatingDaysAmount(creatingVacationDaysList(vacationRequest));

    if (checkIfVacationIsAvailable(daysOff, entitlement)) {
      vacationDao.addVacation(vacationMapper.mapRequestToEntity(employee, vacationRequest));
      updateHolidayEntitlement(vacationRequest, entitlement, daysOff);
      LOGGER.info("Vacation added successfully");

    } else {
      LOGGER.warn("Given days are exceeding entitlement, please choose correct dates.");
    }
  }

  void updateHolidayEntitlement(VacationRequest vacationRequest, int entitlement, int daysOff) {

    if (vacationRequest.getVacationType().equals(VacationType.VACATION)) {

      Employee employee = employeeDao.getEmployeeById(vacationRequest.getEmployeeId());

      employee.setHolidayEntitlement(entitlement - daysOff);

      employeeDao.saveEmployee(employee);

    } else {

      Employee employee = employeeDao.getEmployeeById(vacationRequest.getEmployeeId());

      employee.setAdditionalEntitlement(entitlement - daysOff);

      employeeDao.saveEmployee(employee);
    }

  }

  int getEmployeeEntitlement(Employee employee, VacationRequest vacationRequest) {
    if (vacationRequest.getVacationType().equals(VacationType.VACATION)) {
      return employee.getHolidayEntitlement();
    } else {
      return employee.getAdditionalEntitlement();
    }

  }

  boolean checkIfVacationIsAvailable(int daysOff, int entitlement) {
    return daysOff > entitlement;

  }

  List<LocalDate> creatingVacationDaysList(VacationRequest vacationRequest) {

    LocalDate start = vacationRequest.getDateFrom();
    LocalDate end = vacationRequest.getDateTo();
    List<LocalDate> totalDates = new ArrayList<>();
    while (!start.isAfter(end)) {
      totalDates.add(start);
      start = start.plusDays(1);
    }

    return totalDates;

  }

  Integer calculatingDaysAmount(List<LocalDate> totalDates) {

    List<LocalDate> holidays = new LinkedList<>();
    List<LocalDate> publicHolidayList = holidayDao.listAllHolidayDates();

    for (LocalDate day : totalDates) {
      if ("SATURDAY".equals(day.getDayOfWeek().name())) {
        holidays.add(day);
      } else if ("SUNDAY".equals(day.getDayOfWeek().name())) {
        holidays.add(day);
      } else if (publicHolidayList.contains(day)) {
        holidays.add(day);
      }

    }

    return totalDates.size() - holidays.size();

  }

  public List listAllPendingRequests() {
    return vacationDao.getPendingRequestsList();
  }
}

