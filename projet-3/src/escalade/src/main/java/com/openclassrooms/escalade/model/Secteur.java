package com.openclassrooms.escalade.model;

import java.util.List;

/**
 * Objet m�tier repr�sentant un secteur dans un site d'escalade
 *
 * @author amebarki
 */

public class Secteur {
	
	// ==================== Attributs ====================
	private Integer id;
	private String nom;
	private String description;
	private Integer nbVoies;
	private String orientation;
	private String coordonnees;
	private Integer hauteurMax;
	private List<Voie> voies;
	
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par d�faut.
     */
	public Secteur() {
	}
		
	 /**
     * Constructeur.
     *
     * @param sId -
     */
	public Secteur(Integer sId) {
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

	public Integer getNbVoies() {
		return nbVoies;
	}

	public void setNbVoies(Integer nbVoies) {
		this.nbVoies = nbVoies;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Integer getHauteurMax() {
		return hauteurMax;
	}

	public void setHauteurMax(Integer hauteurMax) {
		this.hauteurMax = hauteurMax;
	}

	public List<Voie> getVoies() {
		return voies;
	}

	public void setVoies(List<Voie> voies) {
		this.voies = voies;
	}

	
	
}
