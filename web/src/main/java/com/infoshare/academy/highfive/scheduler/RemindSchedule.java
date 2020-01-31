package com.infoshare.academy.highfive.scheduler;

import com.infoshare.academy.highfive.dao.VacationDao;
import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.service.configuration.MailSender;
import com.sendgrid.helpers.mail.objects.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Singleton
@Startup
public class RemindSchedule {

    public static final Logger LOGGER = LoggerFactory.getLogger(RemindSchedule.class);
    private static final int INITIAL_DURATION = 120_000;
    private static final int INTERVAL_DURATION = 60_000;
    private static final int SEND_REQEST_OLDER_THEN = 5;

    @Inject
    private MailSender mailSender;

    @Inject
    private VacationDao vacationDao;

    @Resource
    TimerService timerService;

    @PostConstruct
    public void init() {
        LOGGER.info("Created remind schedule been");
        timerService.createTimer(INITIAL_DURATION, INTERVAL_DURATION);
    }

    @Timeout
    public void requestReminderSchedule(Timer timer) throws IOException {

        List<Vacation> requestsToSend = vacationDao.findPendingRequest(LocalDateTime.now().minusMinutes(SEND_REQEST_OLDER_THEN));
        LOGGER.debug("Lenght of requestToSend list {}", requestsToSend.size());
        String employeeWaitingList = requestsToSend.stream()
                .map(vacation -> "- " + vacation.getEmployee().getFirstName() + " " + vacation.getEmployee().getSurname() + "\n")
                .reduce("", (a, v) -> a + v);
        Content content = new Content("text/plain", "Please be advised that there are still vacation requests awaiting confirmation sent by \n"
                + employeeWaitingList + "\n Sincerely,\n Your Administrative Mail " + LocalDateTime.now());
        if (requestsToSend.size() > 0) {
            LOGGER.info("Email will be send");
            mailSender.sendRequestReminder("jjdd8highfive@gmail.com", content);
            requestsToSend.forEach(vacation -> vacation.setReminderEmailSent("1"));
        }
    }
}
