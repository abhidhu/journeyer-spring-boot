package com.journeyer.etour.services;


import java.time.LocalDate;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.journeyer.etour.modal.Booking;
import com.journeyer.etour.modal.Customer;
import com.journeyer.etour.repository.Bookingrepo;
import com.journeyer.etour.repository.Customerrepo;
import com.journeyer.etour.repository.Passangerrepo;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired
	Bookingrepo bookrepo;
	
	@Autowired
	Passangerrepo passrepo;
	
	@Autowired
	Emailservice senderservice;
	
	@Autowired
	Customerrepo custrepo;
	
	@Override
	public void postbooking(Booking booking) {
		// TODO Auto-generated method stub
		passrepo.setflag();
		//int custid=booking.getCustomerid();
		//int packid=booking.getPackageid();
		bookrepo.save(booking);
		
	}

	@Override
	public void canceltours(int bookingid) {
		// TODO Auto-generated method stub
		bookrepo.setflag(bookingid);
	}

	@Override
	public void deletetour(int bookingid) {
		// TODO Auto-generated method stub
		bookrepo.deleteById(bookingid);
	}

		  
	
	   //@EventListener(ApplicationReadyEvent.class) 
//	   public void triggerMail(int custid,int packid) throws MessagingException 
//	   { 
//		   	LocalDate now=LocalDate.now();
//		    String newnow=now.toString();
//		     List<Booking> bookingdetails =bookrepo.findAll();
//		   //senderservice.sendSimpleEmail("darshanraundal55@gmail.com", "This is email body",  "This is email subject"); 
//		     for(Booking book:bookingdetails)
//		     {
//		    	 int pkgid=book.getPackageid();
//		    	 int cid=book.getCustomerid();
//		    	 String date=book.getBookingdate();
//		    	 if(cid==custid && date.equals(newnow) && pkgid==packid)
//		    	 {
//		    		Customer cust=custrepo.findBycustomercid(cid);
//		    		
//		    	 senderservice.sendEmailWithAttachment(cust.getEmail(), "Your Booking Successful",
//						   "Invoice of booking", "C:\\Users\\ASUS\\Downloads\\Invoice"+custid+pkgid+newnow+".pdf");  }
//		     }
//		    	 
//		 }
//		  



	
	 	

}
