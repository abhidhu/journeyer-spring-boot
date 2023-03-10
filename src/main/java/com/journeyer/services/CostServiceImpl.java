package com.journeyer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journeyer.modal.Cost;
import com.journeyer.modal.Sector;
import com.journeyer.repository.Costrepo;
import com.journeyer.repository.Sectorrepo;

@Service
public class CostServiceImpl implements Costservice{

	@Autowired
	Costrepo costrepo;
	
	@Autowired
	Sectorrepo sectorrepo;
	
	public List<Cost> getCost(int sectormasterid) {

		List<Cost> cost=costrepo.findBycostid(sectormasterid);
		
		return cost;
	}

	
	@Override
	public List<Cost> getcostbysubsector(String subsectorid) {
		// TODO Auto-generated method stub
		List<Sector> sectors=sectorrepo.findAll();
		int sectormasterid=0;
		List<Cost> listcost=new ArrayList<Cost>();
		for (Sector sec:sectors)
		{
			String subid=sec.getSubsectorid();
				if(subid.equalsIgnoreCase(subsectorid))
				{
					sectormasterid=sec.getSectormasterid();
					Cost c1=costrepo.findBysubsectorid(sectormasterid);
					listcost.add(c1);
				}
		}
		return listcost;
	}

	@Override
	public List<Cost> getcost() {
		// TODO Auto-generated method stub
		return costrepo.findAll();
	}
}
