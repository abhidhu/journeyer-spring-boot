package com.journeyer.etour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journeyer.etour.modal.Customer;
import com.journeyer.etour.services.CustomerService;

import java.util.List;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/all")
	public List<Customer> getAll() {
		return customerService.getAllCustomer();
	}
	
	
	
}
