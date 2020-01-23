package com.infoshare.academy.highfive.mapper.entity;

import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.dto.request.HolidayRequest;
import com.infoshare.academy.highfive.dto.view.HolidayView;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDate;

@RequestScoped
public class HolidayEntityMapper {

    public HolidayView mapEntityToView(Holiday holiday) {

        HolidayView holidayView = new HolidayView();

        holidayView.setId(holiday.getId());
        holidayView.setName(holiday.getName());
        holidayView.setDescription(holiday.getDescription());
        holidayView.setDate(holiday.getDate());
        holidayView.setHolidayType(holiday.getHolidayType());
        holidayView.setYear(holiday.getDate().getYear());
        holidayView.setMonth(holiday.getDate().getMonthValue());
        holidayView.setDay(holiday.getDate().getDayOfMonth());

        return holidayView;
    }

    public Holiday mapRequestToEntity(HolidayRequest holidayRequest) {
        Holiday holiday = new Holiday();

        return mapRequestToEntity(holidayRequest, holiday);
    }

    public Holiday mapRequestToEntity(HolidayRequest holidayRequest, Holiday holiday) {
        holiday.setName(holidayRequest.getName());
        holiday.setDescription(holidayRequest.getDescription());
        holiday.setHolidayType(holidayRequest.getHolidayType());
        holiday.setDate(LocalDate.parse(holidayRequest.getDate()));
        return holiday;
    }

}
