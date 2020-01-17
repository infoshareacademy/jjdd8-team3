package com.infoshare.academy.highfive.dao;

import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.exception.JsonUrlNotFound;
import com.infoshare.academy.highfive.util.ApiJsonParser;
import com.infoshare.academy.highfive.service.holiday.HolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.IOException;
import java.util.List;

@Singleton
@Startup
public class StartupBean {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private HolidayService holidayService;

    @PostConstruct
    public void initialize() throws IOException {
        logger.info("Initializing service;");
        try {
            ApiJsonParser apiJsonParser = new ApiJsonParser();
            List<Holiday> holidayList = apiJsonParser.parseFromURL("https://acalendarific.com/api/v2/holidays?&api_key=c2ddb57bb630fc01911bbcd01ae5907afaaced8e058cc0f33a938f517c0321e3&country=PL&year=2019");
            if (holidayList != null) {
                holidayList.forEach(holiday -> holidayService.saveHoliday(holiday));
            }
        } catch (JsonUrlNotFound e) {
            logger.warn("Service not initialized {}", e);
            return;
        }
        logger.debug("Service initialized");
    }


}