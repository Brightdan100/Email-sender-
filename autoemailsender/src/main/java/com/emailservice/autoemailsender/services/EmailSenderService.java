package com.emailservice.autoemailsender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmailSenderService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private EmailService emailService;

    public void sendAll(List<String> persons){
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        for (String person : persons) {
            try {
                emailMessage.setFrom(from);
                emailMessage.setTo(person);
                emailMessage.setSubject("TEST from Bright");
                emailMessage.setText("Hello there!, this is just a test");
                emailService.sendEmail(emailMessage);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
