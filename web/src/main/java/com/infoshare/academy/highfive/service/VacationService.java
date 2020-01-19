package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.dao.EntitlementDao;
import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.dao.VacationDao;
import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Entitlement;
import com.infoshare.academy.highfive.domain.VacationType;
import com.infoshare.academy.highfive.mapper.entity.VacationMapper;
import com.infoshare.academy.highfive.dto.request.VacationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@RequestScoped
public class VacationService {

  @Inject
  EmployeeDao employeeDao;

  @Inject
  HolidayDao holidayDao;

  @Inject
  VacationDao vacationDao;

  @Inject
  VacationMapper vacationMapper;

  @Inject
  EntitlementDao entitlementDao;

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  private String status;

  public String getStatus() {
    return status;
  }

  public void addVacation(VacationRequest vacationRequest) {

    Employee employee = employeeDao.getEmployeeById(vacationRequest.getEmployeeId());
    Entitlement entitlement = entitlementDao.getEntitlementByEmployeeId(employee);

    int entitledDays = getEmployeeEntitlement(entitlement, vacationRequest);
    int daysOff = calculatingDaysAmount(creatingVacationDaysList(vacationRequest));

    if (vacationRequest.getDateTo().isBefore((vacationRequest.getDateFrom()))) {

      status = "wrong_date";
    } else {

      if (checkIfVacationIsAvailable(daysOff, entitledDays)) {

        vacationDao.addVacation(vacationMapper.mapRequestToEntity(employee, vacationRequest));
        updateHolidayEntitlement(vacationRequest, daysOff, entitlement);
        LOGGER.info("Vacation added successfully");
        status = "ok";
      } else {
        status = "exceeding_entitlement";

        LOGGER.warn("Given days are exceeding entitledDays.");
      }
    }
  }

  void updateHolidayEntitlement(VacationRequest vacationRequest, int daysOff, Entitlement entitlement) {

    if (vacationRequest.getVacationType().equals(VacationType.PARENTAL)) {

      entitlement.setAdditionalLeft(entitlement.getAdditionalLeft() - daysOff);

    } else if (vacationRequest.getVacationType().equals(VacationType.ON_DEMAND)) {

      entitlement.setOnDemandHolidayLeft(entitlement.getOnDemandHolidayLeft() - daysOff);

    } else {

      entitlement.setVacationLeft(entitlement.getVacationLeft() - daysOff);

    }
    entitlementDao.updateEntitlement(entitlement);
  }

  int getEmployeeEntitlement(Entitlement entitlement, VacationRequest vacationRequest) {

    if (vacationRequest.getVacationType().equals(VacationType.PARENTAL)) {

      return entitlement.getAdditionalLeft();

    } else if (vacationRequest.getVacationType().equals(VacationType.ON_DEMAND)) {

      return entitlement.getOnDemandHolidayLeft();

    } else {

      return entitlement.getVacationLeft() + entitlement.getPreviousYearLeft();

    }

  }

  boolean checkIfVacationIsAvailable(int daysOff, int entitlement) {

    return daysOff <= entitlement;

  }

  List<LocalDate> creatingVacationDaysList(VacationRequest vacationRequest) {

    LocalDate start = vacationRequest.getDateFrom();
    LocalDate end = vacationRequest.getDateTo();
    List<LocalDate> totalDates = new LinkedList<>();
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

