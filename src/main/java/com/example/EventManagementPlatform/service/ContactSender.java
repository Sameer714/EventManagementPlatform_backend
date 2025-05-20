package com.example.EventManagementPlatform.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.EventManagementPlatform.model.GlobalInput.Emailbody;


@Service
public class ContactSender {
	
    private final JavaMailSender mailSender;
    
    @org.springframework.beans.factory.annotation.Value("${spring.mail.username}")
    private String fromMail;
    

    public ContactSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void sendMail(Emailbody body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setTo("sameerpurohit1212@gmail.com");
        simpleMailMessage.setSubject(body.getSub());
        simpleMailMessage.setText("From: " + body.getName() + "\nEmail: " + body.getFrom() + "\n\n" + body.getContent());
        
        mailSender.send(simpleMailMessage);
    }

}
