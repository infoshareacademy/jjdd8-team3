package com.infoshare.academy.highfive.service.holiday;

import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.domain.request.HolidayRequest;
import com.infoshare.academy.highfive.domain.view.HolidayView;
import com.infoshare.academy.highfive.mapper.entity.HolidayEntityMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class HolidayService {

    @EJB
    private HolidayDao holidayDao;

    @Inject
    private HolidayEntityMapper holidayEntityMapper;

    public HolidayView finById(Long id){
        return holidayEntityMapper.mapEntityToView(holidayDao.getById(id).orElseThrow());
    }

    public List<HolidayView> findAll() {

        List<HolidayView> holidayViews = new ArrayList<>();
        holidayDao.listAllHoliday().
                forEach(h -> holidayViews.add(holidayEntityMapper.mapEntityToView(h)));

        return holidayViews;
    }

    public void update(Long id, HolidayRequest holidayRequest) {
        Holiday holiday= holidayDao.getById(id).orElseThrow();

        holidayEntityMapper.mapRequestToEntity(holidayRequest, holiday);

        holidayDao.update(holiday);
    }

    public void saveFromParser(Holiday holiday) {
        if (holiday != null) holidayDao.saveHoliday(holiday);
    }

    public void save(HolidayRequest holidayRequest) {

        Holiday holiday = holidayEntityMapper.mapRequestToEntity(holidayRequest);
        holidayDao.saveHoliday(holiday);

    }

    public HolidayView remove(Long id){
         return holidayEntityMapper.mapEntityToView(holidayDao.deleteById(id));
    }

    public List<Holiday> searchHolidayByName(String searchName) {
        return holidayDao.searchHolidayByName(searchName);
    }

    public List<Holiday> searchHolidayByDate(LocalDate dateFrom, LocalDate dateTo) { return holidayDao.searchHolidayByDate(dateFrom, dateTo);}
}
