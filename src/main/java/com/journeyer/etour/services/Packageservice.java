package com.journeyer.etour.services;

import java.util.List;

import com.journeyer.etour.modal.Tourpackage;

public interface Packageservice {
	
	public List<Tourpackage> getpackage(int sectormasterid);
	public List<Tourpackage> getpackagebysectorid(int packageid);
	public List<Tourpackage> searchpackagebydates();

}
