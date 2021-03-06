package com.openclassrooms.escalade.model;

/**
 * Objet métier représentant une longueur dans une voie
 *
 * @author amebarki
 */

public class Longueur {
	
	// ==================== Attributs ====================
	private Integer id;
	private Integer hauteur;
	private String cotation;
	private Integer nbPoints;
	private boolean equipee;
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par défaut.
     */
	public Longueur() {
	}
		
	 /**
     * Constructeur.
     *
     * @param lId -
     */
	public Longueur(Integer lId) {
		this.id = lId;
	}


    // ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHauteur() {
		return hauteur;
	}
	public void setHauteur(Integer hauteur) {
		this.hauteur = hauteur;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public Integer getNbPoints() {
		return nbPoints;
	}
	public void setNbPoints(Integer nbPoints) {
		this.nbPoints = nbPoints;
	}
	public boolean isEquipee() {
		return equipee;
	}
	public void setEquipee(boolean equipee) {
		this.equipee = equipee;
	}
	
	

}
