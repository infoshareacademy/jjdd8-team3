package com.infoshare.academy.highfive.mapper;

import com.infoshare.academy.highfive.dao.VacationDao;
import com.infoshare.academy.highfive.dto.VacationStatisticView;

import javax.enterprise.context.RequestScoped;

//@RequestScoped
//public class VacationStatisticMapper {
//
//  VacationStatisticView mapEntityToVacationStatistic(VacationDao vacationDao) {
//    VacationStatisticView vacationStatisticView = new VacationStatisticView();
//    vacationStatisticView.setAbsentToday(vacationDao.getAmountOfAbsentToday());
//    vacationStatisticView.setPendingRequests(vacationDao.getPendingRequestsList().size());
//    vacationStatisticView.setCurrentMonthTotal(vacationDao.getAmountOfAbsentThisMonth());
////    vacationStatisticView.setNextMonthTotal(vacationDao.getAmountOfAbsentNextMonth());
//
//  }
//}
