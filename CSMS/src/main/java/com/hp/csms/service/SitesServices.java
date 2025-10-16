package com.hp.csms.service;

import java.util.List;

import com.hp.csms.dto.SitesDto;
import com.hp.csms.entity.Sites;

public interface SitesServices {

	Sites addSite(SitesDto sitedto);

	List<Sites> getAllSites();

	Sites updateSite(SitesDto sitedto);

	Sites getSite(int site_id);

	boolean updateSiteStatus(int site_id, String status);

	boolean deleteSite(int site_id);

}
