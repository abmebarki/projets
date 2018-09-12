package com.openclassrooms.escalade.model;

/**
 * Objet m�tier repr�sentant un administrateur de l'application
 *
 * @author amebarki
 */

public class Administrateur {
	
	// ==================== Attributs ====================
	private Integer id;
	private String codeUtilisateur;
	private String motPasse;
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par d�faut.
     */
	public Administrateur() {
	}
		
	 /**
     * Constructeur.
     *
     * @param aId -
     */
	public Administrateur(Integer aId) {
		this.id = aId;
	}


    // ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeUtilisateur() {
		return codeUtilisateur;
	}

	public void setCodeUtilisateur(String codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
	

}
