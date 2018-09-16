//package com.openclassrooms.escalade.controller;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.openclassrooms.escalade.model.Pret;
//import com.openclassrooms.escalade.service.PretService;
//
//
//@Controller
//@RequestMapping("/")
//public class PretController {
//
//	@Autowired
//	private PretService pretService;
//
//	@RequestMapping(value = "pret/{id}", method = RequestMethod.GET)
//	public String getPretDetails(@PathVariable int id, ModelMap pretModel) {
//		pretModel.addAttribute("pret", pretService.getPret(id));
//		return "pret";
//	}
//
//	@RequestMapping(value = "prets", method = RequestMethod.GET)
//	public String getPretsDetails(ModelMap pretModel) {
//		pretModel.addAttribute("pret", pretService.getAllPret());
//		return "prets";
//	}
//
//	@RequestMapping(value = "addPret")
//	public String addPage() {
//		return "addPret";
//	}
//
//	@RequestMapping(value = "add/pret", method = RequestMethod.POST)
//	public String addPret(@RequestParam(value = "dateDebut", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date dateDebut,
//			@RequestParam(value = "dateFin", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date dateFin, ModelMap pretModel) {
//		Pret pret = new Pret();
//		pret.setDateDebut(dateDebut);
//		pret.setDateFin(dateFin);
//		
//		int resp = pretService.addPret(pret);
//		if (resp > 0) {
//			pretModel.addAttribute("msg", "Pret avec id : " + resp + " ajouté avec succès.");
//			pretModel.addAttribute("pret", pretService.getAllPret());
//			return "prets";
//		} else {
//			pretModel.addAttribute("msg", "Pret addition failed.");
//			return "addPret";
//		}
//	}
//
//	@RequestMapping(value = "delete/pret/{id}", method = RequestMethod.GET)
//	public String deletePret(@PathVariable("id") int id, ModelMap pretModel) {
//		int resp = pretService.deletePret(id);
//		pretModel.addAttribute("pret", pretService.getAllPret());
//		if (resp > 0) {
//			pretModel.addAttribute("msg", "Pret avec id : " + id + " Supprimé avec succès.");
//		} else {
//			pretModel.addAttribute("msg", "Pret avec id : " + id + " suppression échouée.");
//		}
//		return "prets";
//	}
//
//	@RequestMapping(value = "update/pret/{id}", method = RequestMethod.GET)
//	public String updatePage(@PathVariable("id") int id, ModelMap pretModel) {
//		pretModel.addAttribute("id", id);
//		pretModel.addAttribute("pret", pretService.getPret(id));
//		return "updatePret";
//	}
//
//	@RequestMapping(value = "update/pret", method = RequestMethod.POST)
//	public String updatePret(@RequestParam int id, 
//			@RequestParam(value = "dateDebut", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date dateDebut,
//			@RequestParam(value = "dateFin", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date dateFin, ModelMap pretModel) {
//		Pret pret = new Pret();
//		
//		pret.setDateDebut(dateDebut);
//		pret.setDateFin(dateFin);
//		int resp = pretService.updatePret(pret);
//		pretModel.addAttribute("id", id);
//		if (resp > 0) {
//			pretModel.addAttribute("msg", "Pret avec id : " + id + " updated successfully.");
//			pretModel.addAttribute("pret", pretService.getAllPret());
//			return "prets";
//		} else {
//			pretModel.addAttribute("msg", "Pret avec id : " + id + " updation failed.");
//			pretModel.addAttribute("pret", pretService.getPret(id));
//			return "updatePret";
//		}
//	}
//}