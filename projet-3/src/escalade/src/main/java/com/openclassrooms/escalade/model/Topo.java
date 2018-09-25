package com.openclassrooms.escalade.model;

import java.util.Date;
import java.util.List;

/**
 * Objet métier représentant un topo d'escalade
 *
 * @author amebarki
 */

public class Topo {
	
	// ==================== Attributs ====================
	private Integer id;
	private String nom;
	private Integer nbPages;
	private String auteur;
	private Date date;
	private List<Site> descriptibles;
	private Grimpeur createur;
	private Grimpeur proprietaire;
	private List<Commentaire> commentaires;
	private List<Pret> calendrierPret;
		
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par défaut.
     */
	public Topo() {
	}
		
	 /**
     * Constructeur.
     *
     * @param tId -
     */
	public Topo(Integer tId) {
		this.id = tId;
	}

	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbPages() {
		return nbPages;
	}

	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Site> getDescriptibles() {
		return descriptibles;
	}

	public void setDescriptibles(List<Site> descriptibles) {
		this.descriptibles = descriptibles;
	}

	public Grimpeur getCreateur() {
		return createur;
	}

	public void setCreateur(Grimpeur createur) {
		this.createur = createur;
	}

	public Grimpeur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Grimpeur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<Pret> getCalendrierPret() {
		return calendrierPret;
	}

	public void setCalendrierPret(List<Pret> calendrierPret) {
		this.calendrierPret = calendrierPret;
	}

	


	
}
