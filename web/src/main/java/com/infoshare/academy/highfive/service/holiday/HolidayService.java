package com.infoshare.academy.highfive.service.holiday;

import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.domain.view.HolidayView;
import com.infoshare.academy.highfive.mapper.holiday.HolidayMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class HolidayService {

    @EJB
    private HolidayDao holidayDao;

    @EJB
    private HolidayMapper holidayMapper;

    public void saveHoliday(Holiday holiday) {
        if (holiday != null) holidayDao.saveHoliday(holiday);
    }

    public HolidayView finById(Long id){
        return  holidayMapper.mapEntityToView(holidayDao.getById(id).orElseThrow());
    }

    public List<HolidayView> listAllHolidayViews() {
        List<HolidayView> holidayViews = new ArrayList<>();
         holidayDao.listAllHoliday().forEach(h -> holidayViews.add(holidayMapper.mapEntityToView(h)));
         return holidayViews;
    }
}
