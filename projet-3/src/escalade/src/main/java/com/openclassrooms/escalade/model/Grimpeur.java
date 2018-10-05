package com.openclassrooms.escalade.model;

/**
 * Objet métier représentant un grimpeur
 *
 * @author amebarki
 */

public class Grimpeur {
	
	// ==================== Attributs ====================
	private Integer id;
	private String nom;
	private String email;
	private String role;
	private String motpasse;
	
	// ==================== Constructeurs ====================
	 /**
     * Constructeur par défaut.
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

	
    public Grimpeur(Integer id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMotpasse() {
		return motpasse;
	}

	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}

	
	
}
