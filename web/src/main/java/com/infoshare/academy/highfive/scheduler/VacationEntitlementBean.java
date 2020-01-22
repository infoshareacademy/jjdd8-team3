package com.infoshare.academy.highfive.scheduler;

import com.infoshare.academy.highfive.service.EmployeeService;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

@Singleton
@Startup
public class VacationEntitlementBean {

  private static final Logger logger = Logger.getLogger(VacationEntitlementBean.class.getName());

//  @EJB
//  EmployeeService employeeService;
//
//  @Schedule(hour = "1", minute = "37", second = "43", month = "January", dayOfMonth = "1",
//    info = "Update employees vacation on New Year's Eve.")
//  public void updateVacationOnYearStart() {
//    employeeService.updateVacationEntitlementOnYearStart();
//
//  }
//
//  @Schedule(hour = "1", minute = "37", second = "43", month = "September", dayOfMonth = "1",
//    info = "Update employees vacation on September cut off.")
//  public void updateVacationOnSeptember() {
//    employeeService.updateVacationEntitlementOnYearEnd();
//
//  }


}
