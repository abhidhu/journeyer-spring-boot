package com.journeyer.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Service
public class Emailservice {
    private static JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("abhijeetdhumal118981@gmail.com"); // Replace with your Gmail address
        mailSender.setPassword("qxqrkxfzujsddcct"); // Replace with your app-specific password

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }


    public static void  sendEmail(String to,String subject,String test ){
        JavaMailSender mailSender = getJavaMailSender();

        // create email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(test);

        // send the email
        mailSender.send(message);

    }


    public static boolean  sendEmail(String to,String otp ){

        try{
            JavaMailSender mailSender = getJavaMailSender();

            // create email message
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            String subject="OTP:"+otp;
            message.setSubject(subject);


            // send the email
            mailSender.send(message);
        }catch(Exception e){
            System.out.println("Email not send for otp");
            return false;
        }

        return true;
    }


}

