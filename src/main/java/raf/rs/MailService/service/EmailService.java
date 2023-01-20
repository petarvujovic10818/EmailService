package raf.rs.MailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmailService {

    @Autowired
    public JavaMailSender mailSender;

    private RestTemplate userServiceRestTemplate;

    public EmailService(RestTemplate userServiceRestTemplate){
        this.userServiceRestTemplate = userServiceRestTemplate;
    }

    public void sendSimpleMessage(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public String registrationMessage(String name, String surname){
        String msg = "Hi " + name + " " + surname + "!";
        String mssg = msg + "\n\nClick next link to confirm registration"; //need the link logic
        return mssg;
    }

    public String forgotPassword(String name, String surname){
        String msg = "Hi " + name + " " + surname + "!";
        String mssg = msg + "\n\nClick next link to restart your password: "; //need the link logic
        return mssg;
    }

}
