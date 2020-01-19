package com.infoshare.academy.highfive.service.holiday;

import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.domain.Holiday;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class HolidayService {

    @EJB
    private HolidayDao holidayDao;

    public void saveHoliday(Holiday holiday) {
        if (holiday != null) holidayDao.saveHoliday(holiday);
    }

    public Holiday finById(Long id){
        return holidayDao.getById(id);
    }

    public List listAllHoliday() {
        return holidayDao.listAllHoliday();
    }

}
