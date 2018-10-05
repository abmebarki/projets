package com.openclassrooms.escalade.model;

import java.util.List;

/**
 * Objet métier représentant un site d'escalade
 *
 * @author amebarki
 */

public class Site {
	
	// ==================== Attributs ====================
	private Integer id;
	private String nom;
	private String description;
	private List<Exposition> expositions;
	private Integer tempsApproche;
	private List<Saison> saisons;
	private String ville;
	private List<Secteur> secteurs;
	private List<Topo> descripteurs;
	private Grimpeur createur;
	private List<Commentaire> commentaires;
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par défaut.
     */
	public Site() {
	}
		
	 /**
     * Constructeur.
     *
     * @param sId -
     */
	public Site(Integer sId) {
		this.id = sId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public List<Exposition> getExpositions() {
		return expositions;
	}

	public void setExpositions(List<Exposition> expositions) {
		this.expositions = expositions;
	}

	public List<Saison> getSaisons() {
		return saisons;
	}

	public void setSaisons(List<Saison> saisons) {
		this.saisons = saisons;
	}

	public Integer getTempsApproche() {
		return tempsApproche;
	}

	public void setTempsApproche(Integer tempsApproche) {
		this.tempsApproche = tempsApproche;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(List<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public List<Topo> getDescripteurs() {
		return descripteurs;
	}

	public void setDescripteurs(List<Topo> descripteurs) {
		this.descripteurs = descripteurs;
	}

	public Grimpeur getCreateur() {
		return createur;
	}

	public void setCreateur(Grimpeur createur) {
		this.createur = createur;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}



}
