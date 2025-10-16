package com.hp.csms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.csms.dao.SitesDao;
import com.hp.csms.dto.SitesDto;
import com.hp.csms.entity.Sites;
import com.hp.csms.entity.Users;

@Service
public class SitesServicesImpl implements SitesServices{
	
	@Autowired
	SitesDao sitesDao;

	Sites site = new Sites();
	
	@Override
	public Sites addSite(SitesDto sitedto) {
		
		Users u = sitesDao.findByName(sitedto.getManager_name());
		
		if(u!=null) {
		     site.setSite_name(sitedto.getSite_name());
		     site.setLocation(sitedto.getLocation());
		     site.setStartDate(sitedto.getStartDate());
		     site.setEndDate(sitedto.getEndDate());
		     site.setStatus(sitedto.getStatus());
		     site.setManager_id(u);
		     
		    return sitesDao.save(site);      
		}
		
		return null;
	}

	@Override
	public List<Sites> getAllSites() {
		
		List<Sites> sites = (List<Sites>) sitesDao.findAll();
		
		if(sites!=null)
			return sites;
		else
			return null;
	}
	
	@Override
	public Sites getSite(int site_id) {
		
		Optional<Sites> os = sitesDao.findById(site_id);
		
		if(os.isEmpty()) 
			return null;
		else 
			return os.get();
	}

	@Override
	public Sites updateSite(SitesDto sitedto) {
		
        return sitesDao.findById(sitedto.getSite_id()).map(site ->{
        	
        	 site.setSite_name(sitedto.getSite_name());
		     site.setLocation(sitedto.getLocation());
		     site.setStartDate(sitedto.getStartDate());
		     site.setEndDate(sitedto.getEndDate());
		     site.setStatus(sitedto.getStatus());
		     site.setManager_id(sitesDao.findByName(sitedto.getManager_name()));
		     
		     return sitesDao.save(site);
        	
        }).orElseThrow();
		
	}

	@Override
	public boolean updateSiteStatus(int site_id, String status) {
		
		return sitesDao.findById(site_id).map( site ->{
			
			site.setStatus(status);
			sitesDao.save(site);
			
			 return true;
	    }).orElse(false);
		
	}

	@Override
	public boolean deleteSite(int site_id) {
		
		sitesDao.deleteById(site_id);
		
		Optional<Sites> os = sitesDao.findById(site_id);
		if (os.isEmpty())
			return true;
		else
			return false;
	
	}

	
	
	
	
}
