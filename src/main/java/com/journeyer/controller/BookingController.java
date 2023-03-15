package com.journeyer.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.journeyer.modal.Booking;
import com.journeyer.modal.Customer;
import com.journeyer.repository.Bookingrepo;
import com.journeyer.repository.Customerrepo;
import com.journeyer.services.BookingService;
import com.journeyer.services.Emailservice;
//---------------------------------------------------


@RestController
@CrossOrigin
public class BookingController {
	
	@Autowired
	BookingService bookservice;

	@Autowired
	Emailservice emailService;
	
	
	@Autowired
	Bookingrepo bookrepo;
	
	@Autowired
	Emailservice senderservice;
	
	@Autowired
	Customerrepo custrepo;
	
	@PutMapping(value="/canceltour/{bookingid}")
	public void setflag(@PathVariable int bookingid)
	{
		 bookservice.canceltours(bookingid);
	}
	
	@GetMapping(value="/allcanceltours")
	public List<Booking> getallcanceltour()
	{
		return bookrepo.findByflagone();
	}
	
	@DeleteMapping(value="/tourdelete/{bookingid}")
	public void deletetourbyid(@PathVariable int bookingid)
	{
		bookservice.deletetour(bookingid);
	}
	
	//posting the data from pdf page
	@PostMapping(value="/booking/", headers = "Accept=application/json")
	public void postbookingdetails(@RequestBody Booking booking)
	{
		
		System.out.println("inside booking details");
		

		
		System.out.println("inside booking");
		
		System.out.println(booking.getBookingdate());
		for(int i=0;i<=10;i++)
		System.out.println("Hello");
		
		
		bookservice.postbooking(booking);
		
		
		
		int custid=booking.getCustomerid();
		int packid=booking.getPackageid();
		   { 
			   	LocalDate now=LocalDate.now();
			    String newnow=now.toString();
			     List<Booking> bookingdetails =bookrepo.findAll();
			    
			     for(Booking book:bookingdetails)
			     {
			    	
			    	 int pkgid=book.getPackageid();
			    	 int cid=book.getCustomerid();
			    	 String date=book.getBookingdate();
			    	 if(cid==custid && date.equals(newnow) && pkgid==packid)
			    	 {
				    		Customer cust=custrepo.findBycustomercid(cid);
				    		
				    	 
				    		 String subject="Your Booking Successful";
				    		 String body=book.toString();
				    		 
				    		 try {
								 emailService.sendEmail(cust.getEmail(), subject, body);
				    		 }catch(Exception e) {
									e.printStackTrace();
							}

				    	
			    	 }
			     }
			    	 
			 }
		   
		  
			 
			 
	}
	
	//for customer profile
	@GetMapping(value="/alltours/{customerid}")
	public List<Booking> getbookingdetails(@PathVariable int customerid)
	{
		return bookrepo.findBybookingid(customerid);
	}
	
	

}
