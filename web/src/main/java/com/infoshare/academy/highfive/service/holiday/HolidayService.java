package com.infoshare.academy.highfive.service.holiday;

import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.domain.view.HolidayView;
import com.infoshare.academy.highfive.mapper.holiday.HolidayJsonMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class HolidayService {

    @EJB
    private HolidayDao holidayDao;

    @EJB
    private HolidayJsonMapper holidayJsonMapper;

    public void saveHoliday(Holiday holiday) {
        if (holiday != null) holidayDao.saveHoliday(holiday);
    }

    public Holiday finById(Long id){
        return holidayDao.getById(id);
    }

    public List<HolidayView> listAllHolidayViews() {
        List<HolidayView> holidayViews = new ArrayList<>();
         holidayDao.listAllHoliday().forEach(h -> holidayViews.add(holidayJsonMapper.mapEntityToView(h)));
         return holidayViews;
    }
}
