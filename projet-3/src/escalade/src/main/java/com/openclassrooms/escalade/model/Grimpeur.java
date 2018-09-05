package com.openclassrooms.escalade.model;

/**
 * Objet m�tier repr�sentant un grimpeur
 *
 * @author amebarki
 */

public class Grimpeur {
	
	// ==================== Attributs ====================
	private Integer id;
	private String nom;
	private String email;
	
	// ==================== Constructeurs ====================
	 /**
     * Constructeur par d�faut.
     */
	public Grimpeur() {
	}
		
	 /**
     * Constructeur.
     *
     * @param gId -
     */
	public Grimpeur(Integer gId) {
		this.id = gId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
