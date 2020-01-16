package com.infoshare.academy.highfive.service.configuration;

import com.infoshare.academy.highfive.cdi.FileUploadProcessor;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.exception.JsonFileNotFound;
import com.infoshare.academy.highfive.parser.ApiJsonParser;
import com.infoshare.academy.highfive.service.holiday.HolidayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Stateless
public class UploadJsonService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    FileUploadProcessor fileUploadProcessor;

    @Inject
    HolidayService holidayService;

    public List uploadJsonHoliday(Part fileName, String realPath) throws IOException, JsonFileNotFound {

        File uploadedFile = null;
        try {
            uploadedFile = fileUploadProcessor.uploadJsonFile(fileName, realPath);
        } catch (JsonFileNotFound jsonFileNotFound) {
            logger.warn(jsonFileNotFound.getMessage());
        }

        ApiJsonParser apiJsonParser = new ApiJsonParser();
        List<Holiday> holidayListFromUpload = apiJsonParser.parseFromFile(uploadedFile);
        holidayListFromUpload.forEach(holiday -> holidayService.saveHoliday(holiday));
        return holidayListFromUpload;
    }

}
