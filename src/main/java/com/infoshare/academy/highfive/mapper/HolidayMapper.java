package com.infoshare.academy.highfive.mapper;

import com.infoshare.academy.highfive.holiday.Holiday;
import com.infoshare.academy.highfive.view.HolidayDateView;
import com.infoshare.academy.highfive.view.HolidayView;

public class HolidayMapper {


    public HolidayView mapEntityToView(Holiday holiday) {

        return new HolidayView(holiday.getName(), holiday.getDescription(), new HolidayDateView(holiday), holiday.getTypes());
    }

}
