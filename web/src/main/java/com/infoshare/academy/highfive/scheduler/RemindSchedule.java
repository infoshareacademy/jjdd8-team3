package com.infoshare.academy.highfive.scheduler;

import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.service.configuration.MailSender;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

//@Singleton
//@Startup
public class RemindSchedule {

    Logger logger = Logger.getLogger(RemindSchedule.class.getName());

    @Inject
    MailSender mailSender;

    @Inject
    VacationRequest vacationRequest;

// TODO

//    @Schedule(hour = "*", minute = "1", second = "*", info = "Every 1 minute timer")
//    public void requestReminderSchedule() throws IOException {
//        if( < LocalDateTime.now()) {
//            mailSender.sendRequestReminder("mich.chmielewski@gmail.com");
//        }
    }

