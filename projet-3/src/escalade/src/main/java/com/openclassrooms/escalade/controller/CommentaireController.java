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

import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.service.CommentaireService;


@Controller
@RequestMapping("/")
public class CommentaireController {

	@Autowired
	private CommentaireService commentaireService;

	@RequestMapping(value = "commentaire/{id}", method = RequestMethod.GET)
	public String getCommentaireDetails(@PathVariable int id, ModelMap commentaireModel) {
		commentaireModel.addAttribute("commentaire", commentaireService.getCommentaire(id));
		return "commentaire";
	}

	@RequestMapping(value = "commentaires", method = RequestMethod.GET)
	public String getCommentairesDetails(ModelMap commentaireModel) {
		commentaireModel.addAttribute("commentaire", commentaireService.getAllCommentaire());
		return "commentaires";
	}

	@RequestMapping(value = "addCommentaire")
	public String addPage() {
		return "addCommentaire";
	}

	@RequestMapping(value = "add/commentaire", method = RequestMethod.POST)
	public String addCommentaire(@RequestParam(value = "objet", required = true) String objet,
			@RequestParam(value = "contenu", required = true) String contenu,
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date date, ModelMap commentaireModel) {
		Commentaire commentaire = new Commentaire();
		commentaire.setObjet(objet);
		commentaire.setContenu(contenu);
		commentaire.setDate(date);
		
		int resp = commentaireService.addCommentaire(commentaire);
		if (resp > 0) {
			commentaireModel.addAttribute("msg", "Commentaire avec id : " + resp + " ajouté avec succès.");
			commentaireModel.addAttribute("commentaire", commentaireService.getAllCommentaire());
			return "commentaires";
		} else {
			commentaireModel.addAttribute("msg", "Commentaire addition failed.");
			return "addCommentaire";
		}
	}

	@RequestMapping(value = "delete/commentaire/{id}", method = RequestMethod.GET)
	public String deleteCommentaire(@PathVariable("id") int id, ModelMap commentaireModel) {
		int resp = commentaireService.deleteCommentaire(id);
		commentaireModel.addAttribute("commentaire", commentaireService.getAllCommentaire());
		if (resp > 0) {
			commentaireModel.addAttribute("msg", "Commentaire avec id : " + id + " Supprimé avec succès.");
		} else {
			commentaireModel.addAttribute("msg", "Commentaire avec id : " + id + " suppression échouée.");
		}
		return "commentaires";
	}

	@RequestMapping(value = "update/commentaire/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap commentaireModel) {
		commentaireModel.addAttribute("id", id);
		commentaireModel.addAttribute("commentaire", commentaireService.getCommentaire(id));
		return "updateCommentaire";
	}

	@RequestMapping(value = "update/commentaire", method = RequestMethod.POST)
	public String updateCommentaire(@RequestParam int id, 
			@RequestParam(value = "objet", required = true) String objet,
			@RequestParam(value = "contenu", required = true) String contenu,
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern="dd-MM-yyyy")Date date, ModelMap commentaireModel) {
		Commentaire commentaire = new Commentaire();
		commentaire.setId(id);
		commentaire.setObjet(objet);
		commentaire.setContenu(contenu);
		commentaire.setDate(date);
		
		int resp = commentaireService.updateCommentaire(commentaire);
		commentaireModel.addAttribute("id", id);
		if (resp > 0) {
			commentaireModel.addAttribute("msg", "Commentaire avec id : " + id + " updated successfully.");
			commentaireModel.addAttribute("commentaire", commentaireService.getAllCommentaire());
			return "commentaires";
		} else {
			commentaireModel.addAttribute("msg", "Commentaire avec id : " + id + " updation failed.");
			commentaireModel.addAttribute("commentaire", commentaireService.getCommentaire(id));
			return "updateCommentaire";
		}
	}
}