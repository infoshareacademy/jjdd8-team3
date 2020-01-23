package com.infoshare.academy.highfive.service.configuration;

import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.exception.JsonFileNotFound;
import com.infoshare.academy.highfive.service.HolidayService;
import com.infoshare.academy.highfive.util.ApiJsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Stateless
public class UploadJsonService {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    HolidayService holidayService;

    public Integer uploadJsonHoliday(InputStream fileName) throws IOException, JsonFileNotFound {
        ApiJsonParser apiJsonParser = new ApiJsonParser();
        List<Holiday> holidayListFromUpload = apiJsonParser.parseFromInputStream(fileName);
        holidayListFromUpload.forEach(holiday -> holidayService.saveFromParser(holiday));
        LOGGER.info("Uploading Json holiday file!");
        return holidayListFromUpload.size();
    }

}
