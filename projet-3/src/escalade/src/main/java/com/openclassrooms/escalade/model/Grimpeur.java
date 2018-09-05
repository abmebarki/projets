package com.openclassrooms.escalade.model;

import java.util.List;

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
	private List<Site> sitesCrees;
	private List<Site> sitesCommentes;
	private List<Topo> toposCrees;
	private List<Topo> toposProprietes;
	private List<Topo> toposCommentes;
	private List<Pret> toposEmpruntes;
	
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

	public List<Site> getSitesCrees() {
		return sitesCrees;
	}

	public void setSitesCrees(List<Site> sitesCrees) {
		this.sitesCrees = sitesCrees;
	}

	public List<Topo> getToposCrees() {
		return toposCrees;
	}

	public void setToposCrees(List<Topo> toposCrees) {
		this.toposCrees = toposCrees;
	}

	public List<Topo> getToposProprietes() {
		return toposProprietes;
	}

	public void setToposProprietes(List<Topo> toposProprietes) {
		this.toposProprietes = toposProprietes;
	}

	public List<Topo> getToposCommentes() {
		return toposCommentes;
	}

	public void setToposCommentes(List<Topo> toposCommentes) {
		this.toposCommentes = toposCommentes;
	}

	public List<Site> getSitesCommentes() {
		return sitesCommentes;
	}

	public void setSitesCommentes(List<Site> sitesCommentes) {
		this.sitesCommentes = sitesCommentes;
	}

	public List<Pret> getToposEmpruntes() {
		return toposEmpruntes;
	}

	public void setToposEmpruntes(List<Pret> toposEmpruntes) {
		this.toposEmpruntes = toposEmpruntes;
	}
	
	
	
}
