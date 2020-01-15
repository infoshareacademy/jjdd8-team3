package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.parser.ApiJsonParser;
import com.infoshare.academy.highfive.service.HolidayService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.IOException;
import java.util.List;

@Singleton
@Startup
public class StartupBean {
    @EJB
    private HolidayService holidayService;
    @PostConstruct
    public void initialize() throws IOException {
        ApiJsonParser apiJsonParser = new ApiJsonParser();
        List<Holiday> holidayList = apiJsonParser.parseFromURL("https://calendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019");
        holidayList.forEach(holiday -> holidayService.saveHoliday(holiday));
    }


}