package com.journeyer.etour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.journeyer.etour.services.Emailservice;

@SpringBootApplication
public class JourneyerApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(JourneyerApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() throws MessagingException {
//
////	senderservice.sendSimpleEmail("darshanraundal55@gmail.com",
////			"This is email body",
////			"This is email subject");
//	senderservice.sendEmailWithAttachment("darshanraundal55@gmail.com",
//		"This is Arjun Codes",
//		"Resume",
//		"C:\\CDAC vita\\all.pdf");
//	}
	
}

