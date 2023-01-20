package raf.rs.MailService.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import raf.rs.MailService.service.EmailService;

@Component
public class MyTest implements CommandLineRunner {

    private final EmailService emailService;

    @Autowired
    public MyTest(EmailService emailService){
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ide mail....");
//        this.emailService.sendSimpleMessage("pvujovic10818rn@raf.rs", "Subject", "Hello world! \n\nThis is the rhythm of my life!");
    }
}
