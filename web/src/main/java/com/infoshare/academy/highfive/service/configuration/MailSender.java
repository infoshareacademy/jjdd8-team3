package com.infoshare.academy.highfive.service.configuration;

import com.infoshare.academy.highfive.dto.request.VacationRequest;
import com.infoshare.academy.highfive.dto.view.EmployeeView;
import com.infoshare.academy.highfive.service.EmployeeService;
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
import javax.inject.Inject;
import java.io.IOException;

@RequestScoped
public class MailSender {

  Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

  @Inject
  EmployeeService employeeService;

  private void createMail(Email from, String subject, Email to, Content content) throws IOException {
    Mail mail = new Mail(from, subject, to, content);
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());
    Response response = sg.api(request);
    System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        System.out.println(response.getHeaders());
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

  public void sendNotification(VacationRequest vacationRequest, String emailRecipient) throws IOException {
    EmployeeView employeeView = employeeService.findById(vacationRequest.getEmployeeId());
    String contentValue = "Please be informed new vacation request is waiting for your approval. Vacation requested by " + employeeView.getFirstName()
      + " " + employeeView.getSurname() + ". " + vacationRequest.getVacationType().getVacationType() + " from: " + vacationRequest.getDateFrom() + " to " + vacationRequest.getDateTo();
    Email from = new Email("Vacation-Manager@HighFive.com");
    String subject = "Vacation Manager notification. New vacation request.";
    Email to = new Email(emailRecipient);
    Content content = new Content("text/plain", contentValue);
    createMail(from, subject, to, content);

  }

  public void sendRequestReminder(String emailRecipient, Content content) throws IOException {

    Email from = new Email("Vacation-Manager@HighFive.com");
    String subject = "Vacation Manager notification. Request reminder.";
    Email to = new Email(emailRecipient);
    createMail(from, subject, to, content);

  }

}
