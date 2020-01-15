package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.domain.Holiday;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class HolidayService {

    @EJB
    private HolidayDao holidayDao;

    public void saveHoliday(Holiday holiday){
        holidayDao.saveHoliday(holiday);
    }

    public List listAllHoliday(){
        return holidayDao.listAllHoliday();
    }

}
