package com.infoshare.academy.highfive.service.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;

@RequestScoped
public class MailSender {

    private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";
    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private PropertiesLoaderService propertiesLoaderService;

    public void sendMessage(List<String> recipients, String subject, String emailContent)
            throws MessagingException {

        try {
            Session getMailSession = Session
                    .getDefaultInstance(propertiesLoaderService.loadMailProperties(), null);

            MimeMessage generateMailMessage = new MimeMessage(getMailSession);

            for (String recipient : recipients) {
                generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }
            generateMailMessage.setSubject(subject);
            generateMailMessage.setContent(emailContent, "text/html");

            Transport transport = getMailSession.getTransport(MAIL_TRANSPORT_PROTOCOL);

            String username = propertiesLoaderService.loadCredentialsProperties()
                    .getProperty("user.name");
            String password = propertiesLoaderService.loadCredentialsProperties()
                    .getProperty("user.password");
            String server = propertiesLoaderService.loadServerProperties().getProperty("mail.smtp.host");

            LOGGER.info("Email send to {}", username);
            transport.connect(server, username, password);
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

//    public void sendApprove(String emailRecipient) throws IOException {
//
//            Optional<String> emailOpt = Optional
//                    .ofNullable(req.getSession().getAttribute("email").toString());
//            String email = emailOpt.get();
//            User user = userService.getUserByEmail(email);
//
//            reservationService.newReservation(idParam, email);
//            List<String> recipients = new ArrayList<>();
//            recipients.add(email);
//            String subject = "Rezerwacja książki " + "\"" + book.getTitle() + "\"";
//            emailSenderService.sendMessage(recipients, subject);
//
//        }
//
//    public void sendReject(String emailRecipient) throws IOException {
//
//        Email from = new Email("Vacation-Manager@HighFive.com");
//        String subject = "Vacation Manager notification. Your request has been rejected.";
//        Email to = new Email(emailRecipient);
//        Content content = new Content("text/plain", "Please be informed your vacation request has been rejected.");
//        createMail(from, subject, to, content);
//
//    }
//
//    public void sendNotification(String emailRecipient) throws IOException {
//
//        Email from = new Email("Vacation-Manager@HighFive.com");
//        String subject = "Vacation Manager notification. New vacation request.";
//        Email to = new Email(emailRecipient);
//        Content content = new Content("text/plain", "Please be informed new vacation request is waiting for your approval");
//        createMail(from, subject, to, content);
//
//    }
//
//    public void sendRequestReminder(String emailRecipient, Content content) throws IOException {
//
//        Email from = new Email("Vacation-Manager@HighFive.com");
//        String subject = "Vacation Manager notification. Request reminder.";
//        Email to = new Email(emailRecipient);
//        createMail(from, subject, to, content);
//
//    }
//
//}
    }
