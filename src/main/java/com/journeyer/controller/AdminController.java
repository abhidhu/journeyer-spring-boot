package com.journeyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.journeyer.modal.Booking;
import com.journeyer.modal.Customer;
import com.journeyer.services.BookingService;
import com.journeyer.services.CustomerService;

import java.util.List;



@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping(value="Admin/customers")
	public List<Customer> getAll() {
		return customerService.getAllCustomer();
	}
	
//	@GetMapping(value="Admin/customer-booking/{custId}")
//	public List<Booking> getCustomerBooking(@PathVariable int custId) {
//		
//		
//		Customer cust=customerService.getcustomerbycustid(custId);
//		return bookingService.getBookingByCustId(custId);
//	
//	}	
}
