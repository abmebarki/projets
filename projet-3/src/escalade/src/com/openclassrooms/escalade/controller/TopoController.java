package com.openclassrooms.escalade.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.service.TopoService;


@Controller
@RequestMapping("/")
public class TopoController {

	@Autowired
	private TopoService topoService;

	@RequestMapping(value = "topo/{id}", method = RequestMethod.GET)
	public String getTopoDetails(@PathVariable int id, ModelMap topoModel) {
		topoModel.addAttribute("topo", topoService.getTopo(id));
		return "topo";
	}

	@RequestMapping(value = "topos", method = RequestMethod.GET)
	public String getToposDetails(ModelMap topoModel) {
		topoModel.addAttribute("topo", topoService.getAllTopo());
		return "topos";
	}

	@RequestMapping(value = "addTopo")
	public String addPage() {
		return "addTopo";
	}

	@RequestMapping(value = "add/topo", method = RequestMethod.POST)
	public String addTopo(@RequestParam(value = "nom", required = true) String nom,
			@RequestParam(value = "nbPages", required = true) Integer nbPages,
			@RequestParam(value = "auteur", required = true) String auteur,
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date date, ModelMap topoModel) {
		Topo topo = new Topo();
		topo.setNom(nom);
		topo.setNbPages(nbPages);
		topo.setAuteur(auteur);
		topo.setDate(date);
		int resp = topoService.addTopo(topo);
		if (resp > 0) {
			topoModel.addAttribute("msg", "Topo avec id : " + resp + " ajouté avec succès.");
			topoModel.addAttribute("topo", topoService.getAllTopo());
			return "topos";
		} else {
			topoModel.addAttribute("msg", "Topo addition failed.");
			return "addTopo";
		}
	}

	@RequestMapping(value = "delete/topo/{id}", method = RequestMethod.GET)
	public String deleteTopo(@PathVariable("id") int id, ModelMap topoModel) {
		int resp = topoService.deleteTopo(id);
		topoModel.addAttribute("topo", topoService.getAllTopo());
		if (resp > 0) {
			topoModel.addAttribute("msg", "Topo avec id : " + id + " Supprimé avec succès.");
		} else {
			topoModel.addAttribute("msg", "Topo avec id : " + id + " suppression échouée.");
		}
		return "topos";
	}

	@RequestMapping(value = "update/topo/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap topoModel) {
		topoModel.addAttribute("id", id);
		topoModel.addAttribute("topo", topoService.getTopo(id));
		return "updateTopo";
	}

	@RequestMapping(value = "update/topo", method = RequestMethod.POST)
	public String updateTopo(@RequestParam int id, 
			@RequestParam(value = "nom", required = true) String nom,
			@RequestParam(value = "nbPages", required = true) Integer nbPages,
			@RequestParam(value = "auteur", required = true) String auteur,
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date date, ModelMap topoModel) {
		Topo topo = new Topo();
		topo.setId(id);
		topo.setNom(nom);
		topo.setNbPages(nbPages);
		topo.setAuteur(auteur);
		topo.setDate(date);
		int resp = topoService.updateTopo(topo);
		topoModel.addAttribute("id", id);
		if (resp > 0) {
			topoModel.addAttribute("msg", "Topo avec id : " + id + " updated successfully.");
			topoModel.addAttribute("topo", topoService.getAllTopo());
			return "topos";
		} else {
			topoModel.addAttribute("msg", "Topo avec id : " + id + " updation failed.");
			topoModel.addAttribute("topo", topoService.getTopo(id));
			return "updateTopo";
		}
	}
}