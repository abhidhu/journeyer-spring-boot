package com.journeyer.services;

import java.util.List;

import com.journeyer.modal.Customer;

public interface CustomerService {

	public List<Customer> getcustomerbyid(int cust_Id);
	 
	//public String getallcustomers(Customer customer);
	
	public Customer getcustomerbycustid(int cust_Id);
	
	public List<Customer> getAllCustomer();

}
