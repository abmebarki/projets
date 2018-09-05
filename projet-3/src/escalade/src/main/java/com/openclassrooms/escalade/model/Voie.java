package com.openclassrooms.escalade.model;

import java.util.List;

/**
 * Objet m�tier repr�sentant une voie dans une secteur
 *
 * @author amebarki
 */

public class Voie {
	
	// ==================== Attributs ====================
	private Integer id;
	private String nom;
	private Integer nbLongueurs;
	private Secteur secteur;
	private List<Longueur> longueurs;
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par d�faut.
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

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public List<Longueur> getLongueurs() {
		return longueurs;
	}

	public void setLongueurs(List<Longueur> longueurs) {
		this.longueurs = longueurs;
	}
	
	
	
}
