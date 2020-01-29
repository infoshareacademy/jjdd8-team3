package com.infoshare.academy.highfive.scheduler;

import com.infoshare.academy.highfive.dao.VacationDao;
import com.infoshare.academy.highfive.domain.Vacation;
import com.infoshare.academy.highfive.service.configuration.MailSender;
import com.sendgrid.helpers.mail.objects.Content;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Singleton
@Startup
public class RemindSchedule {

    @Inject
    MailSender mailSender;

    @Inject
    VacationDao vacationDao;

    @Schedule(hour = "*", minute = "1", second = "*", info = "Every 1 minute timer")
    public void requestReminderSchedule() throws IOException {

        List<Vacation> requestsToSend = vacationDao.findPendingRequest(LocalDateTime.now().minusMinutes(15));
        String employeeWaitingList = requestsToSend.stream()
                .map(vacation -> "- " + vacation.getEmployee().getFirstName() + " " + vacation.getEmployee().getSurname() + "\n")
                .reduce("", (a, v) -> a + v);
        Content content = new Content("text/plain", "Please be advised that there are still vacation requests awaiting confirmation sent by \n"
                + employeeWaitingList + "\n Sincerely,\n Your Administrative Mail");
        mailSender.sendRequestReminder("jjdd8highfive@gmail.com", content);
        requestsToSend.stream().forEach(vacation -> vacation.setReminderEmailSent(true));

    }
}
