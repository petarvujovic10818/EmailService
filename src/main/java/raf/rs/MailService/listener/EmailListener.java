package raf.rs.MailService.listener;

import org.springframework.stereotype.Component;
import raf.rs.MailService.service.EmailService;

@Component
public class EmailListener {

    private EmailService emailService;

    public EmailListener(EmailService emailService){
        this.emailService = emailService;
    }

    public void addOrder(){
        emailService.sendSimpleMessage("pvujovic10818rn@raf.rs", "Subject", "Some random text!");
    }

}
