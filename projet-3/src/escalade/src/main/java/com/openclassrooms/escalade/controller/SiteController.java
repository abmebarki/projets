package com.openclassrooms.escalade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.service.SiteService;

@Controller
public class SiteController {

	@Autowired
	private SiteService siteService;
	
    @RequestMapping(value="/sites", method=RequestMethod.GET)
    
    
    public String getListSite(Model model) {	
    	
    	List<Site> siteList = siteService.getListSite();
    	model.addAttribute("sites", siteList );
    	return "sites";
    	
    }
}