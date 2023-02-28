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
	

	
}

