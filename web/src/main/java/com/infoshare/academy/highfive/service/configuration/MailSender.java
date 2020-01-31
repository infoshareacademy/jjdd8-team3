package com.infoshare.academy.highfive.service.configuration;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;

@RequestScoped
public class MailSender {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    private void createMail(Email from, String subject, Email to, Content content) throws IOException {
        Mail mail = new Mail(from, subject, to, content);

//        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
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        LOGGER.info("{}", response.getStatusCode());
        LOGGER.info("{}", response.getBody());
        LOGGER.info("{}", response.getHeaders());
    }

    public void sendApprove(String emailRecipient) throws IOException {

        Email from = new Email("Vacation-Manager@HighFive.com");
        String subject = "Vacation Manager notification. Your request has been approved.";
        Email to = new Email(emailRecipient);
        Content content = new Content("text/plain", "Please be informed your vacation request has been approved.");
        createMail(from, subject, to, content);

    }

    public void sendReject(String emailRecipient) throws IOException {

        Email from = new Email("Vacation-Manager@HighFive.com");
        String subject = "Vacation Manager notification. Your request has been rejected.";
        Email to = new Email(emailRecipient);
        Content content = new Content("text/plain", "Please be informed your vacation request has been rejected.");
        createMail(from, subject, to, content);

    }

    public void sendNotification(String emailRecipient) throws IOException {

        Email from = new Email("Vacation-Manager@HighFive.com");
        String subject = "Vacation Manager notification. New vacation request.";
        Email to = new Email(emailRecipient);
        Content content = new Content("text/plain", "Please be informed new vacation request is waiting for your approval");
        createMail(from, subject, to, content);

    }

    public void sendRequestReminder(String emailRecipient, Content content) throws IOException {

        Email from = new Email("Vacation-Manager@HighFive.com");
        String subject = "Vacation Manager notification. Request reminder.";
        Email to = new Email(emailRecipient);
        createMail(from, subject, to, content);

    }

}
