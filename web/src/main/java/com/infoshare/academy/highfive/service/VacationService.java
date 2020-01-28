package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.EmployeeDao;
import com.infoshare.academy.highfive.dao.EntitlementDao;
import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.dao.VacationDao;
import com.infoshare.academy.highfive.domain.*;
import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.dto.view.VacationStatisticView;
import com.infoshare.academy.highfive.dto.view.VacationView;
import com.infoshare.academy.highfive.mapper.entity.VacationMapper;
import com.infoshare.academy.highfive.service.configuration.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

  @Inject
  MailSender mailSender;

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  private String status;

  public String getStatus() {
    return status;
  }

  public void addVacation(VacationRequest vacationRequest) {

    Employee employee = employeeDao.findById(vacationRequest.getEmployeeId());
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

  @Transactional
  public List<VacationView> listAllPendingRequests() {

    return vacationDao.getPendingRequestsList()
      .stream()
      .map(vacation -> vacationMapper.mapEntityToView(vacation))
      .collect(Collectors.toList());

  }

  public void changeVacationStatus(Long vacationId, VacationStatus vacationStatus) throws IOException {

    Vacation vacation = vacationDao.getVacationById(vacationId);
    vacation.setVacationStatus(vacationStatus);
    vacationDao.updateVacationStatus(vacation);

    if (vacationStatus.equals(VacationStatus.APPROVED)) {

      mailSender.sendApprove(vacation.getEmployee().getEmail());

    } else {
      mailSender.sendReject(vacation.getEmployee().getEmail());
    }

  }

  public VacationStatisticView getStatistics() {
    VacationStatisticView vacationStatisticView = new VacationStatisticView();
    vacationStatisticView.setNextMonthTotal(vacationDao.getAmountOfAbsentNextMonth());
    vacationStatisticView.setCurrentMonthTotal(vacationDao.getAmountOfAbsentThisMonth());
    vacationStatisticView.setPendingRequests(vacationDao.getPendingRequestsListSize());
    vacationStatisticView.setAbsentToday(vacationDao.getAmountOfAbsentToday());
    return vacationStatisticView;
  }
}

