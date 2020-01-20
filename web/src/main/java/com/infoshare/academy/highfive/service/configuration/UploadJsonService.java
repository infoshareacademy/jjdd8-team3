package com.infoshare.academy.highfive.service.configuration;

import com.infoshare.academy.highfive.cdi.FileUploadProcessor;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.domain.request.HolidayRequest;
import com.infoshare.academy.highfive.domain.view.HolidayView;
import com.infoshare.academy.highfive.exception.JsonFileNotFound;
import com.infoshare.academy.highfive.service.holiday.HolidayService;
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

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    FileUploadProcessor fileUploadProcessor;

    @Inject
    HolidayService holidayService;

//    public Integer uploadJsonHoliday(Part fileName) throws IOException, JsonFileNotFound {
//
//        File uploadedFile = null;
//        try {
//            uploadedFile = fileUploadProcessor.uploadJsonFile(fileName);
//        } catch (JsonFileNotFound jsonFileNotFound) {
//            logger.warn(jsonFileNotFound.getMessage());
//        }
//
//        ApiJsonParser apiJsonParser = new ApiJsonParser();
//        List<Holiday> holidayListFromUpload = apiJsonParser.parseFromFile(uploadedFile);
//        holidayListFromUpload.forEach(holiday -> holidayService.saveHoliday(holiday));
//        return holidayListFromUpload.size();
//    }

    public Integer uploadJsonHoliday(InputStream fileName) throws IOException, JsonFileNotFound {
        ApiJsonParser apiJsonParser = new ApiJsonParser();
        List<Holiday> holidayListFromUpload = apiJsonParser.parseFromInputStream(fileName);
        holidayListFromUpload.forEach(holiday -> holidayService.saveFromParser(holiday));
        return holidayListFromUpload.size();
    }

}
