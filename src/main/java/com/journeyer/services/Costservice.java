package com.journeyer.services;

import java.util.List;

import com.journeyer.modal.Cost;

public interface Costservice {
	
	public List<Cost> getCost(int sectormasterid);
	
		public List<Cost> getcostbysubsector(String subsectorid);
		
		public List<Cost> getcost();
}
