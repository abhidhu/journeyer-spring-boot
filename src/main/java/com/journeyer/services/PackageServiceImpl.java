package com.journeyer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journeyer.modal.Tourpackage;
import com.journeyer.repository.Packagerepo;

@Service
public class PackageServiceImpl implements Packageservice{

	@Autowired
	Packagerepo packrepo;

	@Override
	public List<Tourpackage> getpackage(int sectormasterid) {
		// TODO Auto-generated method stub
		
		List<Tourpackage> pack=packrepo.findBypackageid(sectormasterid);
		return pack;
	}

	@Override
	public List<Tourpackage> getpackagebysectorid(int packageid) {
		// TODO Auto-generated method stub
		return packrepo.findBysectorid(packageid);
	}

	@Override
	public List<Tourpackage> searchpackagebydates() {

		return packrepo.findAll();
	}
	
	
	

}
