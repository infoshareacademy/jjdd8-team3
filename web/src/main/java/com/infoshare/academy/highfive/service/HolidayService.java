package com.infoshare.academy.highfive.service;

import com.infoshare.academy.highfive.dao.HolidayDao;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.dto.request.HolidayRequest;
import com.infoshare.academy.highfive.dto.view.HolidayView;
import com.infoshare.academy.highfive.mapper.entity.HolidayEntityMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class HolidayService {

    @EJB
    private HolidayDao holidayDao;

    @Inject
    private HolidayEntityMapper holidayEntityMapper;

    public HolidayView finById(Long id) {
        return holidayEntityMapper.mapEntityToView(holidayDao.getById(id).orElseThrow());
    }

    public List<HolidayView> findAll() {

        List<HolidayView> holidayViews = new ArrayList<>();
        holidayDao.listAllHoliday().
                forEach(h -> holidayViews.add(holidayEntityMapper.mapEntityToView(h)));

        return holidayViews;
    }

    public void update(Long id, HolidayRequest holidayRequest) {
        Holiday holiday = holidayDao.getById(id).orElseThrow();

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

    public HolidayView remove(Long id) {
        return holidayEntityMapper.mapEntityToView(holidayDao.deleteById(id));
    }

    public List<HolidayView> searchHolidayByName(String searchName) {

        List<HolidayView> holidayViews = new ArrayList<>();
        holidayDao.searchHolidayByName(searchName).
                forEach(h -> holidayViews.add(holidayEntityMapper.mapEntityToView(h)));

        return holidayViews;
    }

    public List<HolidayView> searchHolidayByDate(LocalDate dateFrom, LocalDate dateTo) {

        List<HolidayView> holidayViews = new ArrayList<>();
        holidayDao.searchHolidayByDate(dateFrom, dateTo).
                forEach(h -> holidayViews.add(holidayEntityMapper.mapEntityToView(h)));

        return holidayViews;
    }
}
