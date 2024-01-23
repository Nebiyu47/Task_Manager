package com.example.taskmanmager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    private final String username = "nebiyugirma609@gmail.com";

    // Replace with your Gmail app password or account password
    private final String password = " cin";
    @Bean
    public JavaMailSender javaMailSender(){
    JavaMailSenderImpl mailSender= new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);
    mailSender.setUsername(username);
    mailSender.setPassword(password);
    Properties props=mailSender.getJavaMailProperties();
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.transport.protocol", "smtp");
    return mailSender;
}
}
