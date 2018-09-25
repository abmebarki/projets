package com.openclassrooms.escalade.model;

import java.util.List;

/**
 * Objet métier représentant une voie dans une secteur
 *
 * @author amebarki
 */

public class Voie {
	
	// ==================== Attributs ====================
	private Integer id;
	private String nom;
	private Integer nbLongueurs;
	private List<Longueur> longueurs;
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par défaut.
     */
	public Voie() {
	}
		
	 /**
     * Constructeur.
     *
     * @param vId -
     */
	public Voie(Integer vId) {
		this.id = vId;
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

	public Integer getNbLongueurs() {
		return nbLongueurs;
	}

	public void setNbLongueurs(Integer nbLongueurs) {
		this.nbLongueurs = nbLongueurs;
	}

	public List<Longueur> getLongueurs() {
		return longueurs;
	}

	public void setLongueurs(List<Longueur> longueurs) {
		this.longueurs = longueurs;
	}
	
	
	
}
