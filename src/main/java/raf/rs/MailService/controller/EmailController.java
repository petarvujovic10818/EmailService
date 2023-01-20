package raf.rs.MailService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raf.rs.MailService.dto.UserInfoDto;
import raf.rs.MailService.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> sendRegistrationMail(@RequestBody UserInfoDto userInfoDto){
        emailService.sendSimpleMessage(userInfoDto.getEmail(), "Confirm registration", emailService.registrationMessage(userInfoDto.getName(), userInfoDto.getSurname()));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/password")
    public ResponseEntity<?> sendForgotPasswordMail(@RequestBody UserInfoDto userInfoDto){
        emailService.sendSimpleMessage(userInfoDto.getEmail(), "Forgot password", emailService.forgotPassword(userInfoDto.getName(), userInfoDto.getSurname()));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
