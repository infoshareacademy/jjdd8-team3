package com.infoshare.academy.highfive.mapper.holiday;

import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.domain.view.HolidayView;

import javax.ejb.Stateless;

@Stateless
public class HolidayMapper {

    public HolidayView mapEntityToView(Holiday holiday) {
        HolidayView holidayView = new HolidayView();

        holidayView.setId(holiday.getId());
        holidayView.setName(holiday.getName());
        holidayView.setDescription(holiday.getDescription());
        holidayView.setDate(holiday.getDate());
        holidayView.setHolidayType(holiday.getHolidayType());

        return holidayView;
    }

}
