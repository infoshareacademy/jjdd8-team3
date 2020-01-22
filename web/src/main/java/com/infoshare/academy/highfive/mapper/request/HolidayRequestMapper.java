package com.infoshare.academy.highfive.mapper.request;

import com.infoshare.academy.highfive.domain.HolidayType;
import com.infoshare.academy.highfive.dto.request.HolidayRequest;

import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;

@RequestScoped
public class HolidayRequestMapper {

    public HolidayRequest mapParamsToRequest(HttpServletRequest request)
            throws IOException, ServletException {

        HolidayRequest holidayRequest = new HolidayRequest();

        holidayRequest.setName(request.getParameter("name"));
        holidayRequest.setDescription(request.getParameter("description"));
        holidayRequest.setDate(LocalDate.parse(request.getParameter("data")));
        holidayRequest.setHolidayType(HolidayType.valueOf(request.getParameter("type")));

        return holidayRequest;
    }
}
