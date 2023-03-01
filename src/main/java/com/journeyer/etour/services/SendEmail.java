package com.journeyer.etour.services;


//import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



//This is utility class

@Service
public class SendEmail {
	static void sendEmail() {}
	
	 @Autowired
	 private JavaMailSender mailSender;

	 public void sendEmail(String to, String subject, String body) {
		 
		 try {
			 SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(to);
		        message.setSubject(subject);
		        message.setText(body);

		        mailSender.send(message);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	       
	 }
	 public void sendEmailWithAttachment(String to, String subject, String body) throws MessagingException, IOException {

//		 MimeMessage message = JavaMailSender.createMimeMessage();
//		 MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//
//		 helper.setTo(to);
//		 helper.setSubject(subject);
//		 helper.setText(body);
//
//		 FileSystemResource file = new FileSystemResource(new File("attachment.jpg"));
//		 helper.addAttachment("attachment.jpg", file);
//
//		 mailSender.send(message);
	}
	 
	 
	 
	 
	 
	 
	 
	 
}


/*
int custid=booking.getCustomerid();
int packid=booking.getPackageid();
   { 
	   	LocalDate now=LocalDate.now();
	    String newnow=now.toString();
	     List<Booking> bookingdetails =bookrepo.findAll();
	   //senderservice.sendSimpleEmail("darshanraundal55@gmail.com", "This is email body",  "This is email subject"); 
	     for(Booking book:bookingdetails)
	     {
	    	 int pkgid=book.getPackageid();
	    	 int cid=book.getCustomerid();
	    	 String date=book.getBookingdate();
	    	 if(cid==custid && date.equals(newnow) && pkgid==packid)
	    	 {
	    		Customer cust=custrepo.findBycustomercid(cid);
	    		
	    	 try {
				senderservice.sendEmailWithAttachment(cust.getEmail(), "Your Booking Successful",
						   "Invoice of booking", "C:\\Users\\dhuma\\Downloads\\Invoice"+custid+pkgid+newnow+".pdf");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
				for(int i=0;i<=10;i++)
					System.out.println("Hello");
			}  }
	     }
	    	 
	 }

*/