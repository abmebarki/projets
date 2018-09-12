package com.openclassrooms.escalade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.service.SiteService;


@Controller
@RequestMapping("/")
public class SiteController {

	@Autowired
	private SiteService siteService;

	@RequestMapping(value = "site/{id}", method = RequestMethod.GET)
	public String getSiteDetails(@PathVariable int id, ModelMap siteModel) {
		siteModel.addAttribute("site", siteService.getSite(id));
		return "site";
	}

	@RequestMapping(value = "sites", method = RequestMethod.GET)
	public String getSitesDetails(ModelMap siteModel) {
		siteModel.addAttribute("site", siteService.getAllSite());
		return "sites";
	}

	@RequestMapping(value = "addSite")
	public String addPage() {
		return "addSite";
	}

	@RequestMapping(value = "add/site", method = RequestMethod.POST)
	public String addSite(@RequestParam(value = "nom", required = true) String nom,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "nbSecteurs", required = true) Integer nbSecteurs,
			@RequestParam(value = "ville", required = true) String ville, ModelMap siteModel) {
		Site site = new Site();
		site.setNom(nom);
		site.setDescription(description);
		site.setNbSecteurs(nbSecteurs);
		site.setVille(ville);
		int resp = siteService.addSite(site);
		if (resp > 0) {
			siteModel.addAttribute("msg", "Site avec id : " + resp + " ajouté avec succès.");
			siteModel.addAttribute("site", siteService.getAllSite());
			return "sites";
		} else {
			siteModel.addAttribute("msg", "Site addition failed.");
			return "addSite";
		}
	}

	@RequestMapping(value = "delete/site/{id}", method = RequestMethod.GET)
	public String deleteSite(@PathVariable("id") int id, ModelMap siteModel) {
		int resp = siteService.deleteSite(id);
		siteModel.addAttribute("site", siteService.getAllSite());
		if (resp > 0) {
			siteModel.addAttribute("msg", "Site avec id : " + id + " Supprimé avec succès.");
		} else {
			siteModel.addAttribute("msg", "Site avec id : " + id + " suppression échouée.");
		}
		return "sites";
	}

	@RequestMapping(value = "update/site/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap siteModel) {
		siteModel.addAttribute("id", id);
		siteModel.addAttribute("site", siteService.getSite(id));
		return "updateSite";
	}

	@RequestMapping(value = "update/site", method = RequestMethod.POST)
	public String updateSite(@RequestParam int id, 
			@RequestParam(value = "nom", required = true) String nom,
			@RequestParam(value = "description", required = true) String description,
			@RequestParam(value = "nbSecteurs", required = true) Integer nbSecteurs,
			@RequestParam("ville") String ville, ModelMap siteModel) {
		Site site = new Site();
		site.setId(id);
		site.setNom(nom);
		site.setDescription(description);
		site.setNbSecteurs(nbSecteurs);
		site.setVille(ville);
		int resp = siteService.updateSite(site);
		siteModel.addAttribute("id", id);
		if (resp > 0) {
			siteModel.addAttribute("msg", "Site avec id : " + id + " updated successfully.");
			siteModel.addAttribute("site", siteService.getAllSite());
			return "sites";
		} else {
			siteModel.addAttribute("msg", "Site avec id : " + id + " updation failed.");
			siteModel.addAttribute("site", siteService.getSite(id));
			return "updateSite";
		}
	}
}