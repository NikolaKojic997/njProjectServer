package com.njProjectServer.model.email;

import com.njProjectServer.config.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailSender {

    @Autowired
    private EmailConfiguration emailConfiguration;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfiguration.getHost());
        mailSender.setPort(emailConfiguration.getPort());

        mailSender.setUsername(emailConfiguration.getUsername());
        mailSender.setPassword(emailConfiguration.getPassword());

        Properties props = mailSender.getJavaMailProperties();

        props.put("mail.smtp.auth", emailConfiguration.isAuth());
        props.put("mail.smtp.starttls.enable", emailConfiguration.isStarttls());


        return mailSender;
    }
}
