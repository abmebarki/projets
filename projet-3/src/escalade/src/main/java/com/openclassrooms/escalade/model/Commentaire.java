package com.openclassrooms.escalade.model;

import java.util.Date;

/**
 * Objet m�tier repr�sentant un commentaire d'un topo ou un site d'escalade
 *
 * @author amebarki
 */

public class Commentaire {
	
	// ==================== Attributs ====================
	private Integer id;
	private String objet;
	private String contenu;
	private Date date;
	private Grimpeur auteur;
	private Topo topoCommente;
	private Site siteCommente;
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par d�faut.
     */
	public Commentaire() {
	}
		
	 /**
     * Constructeur.
     *
     * @param cId -
     */
	public Commentaire(Integer cId) {
		this.id = cId;
	}

	// ==================== Getters/Setters ====================
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Grimpeur getAuteur() {
		return auteur;
	}

	public void setAuteur(Grimpeur auteur) {
		this.auteur = auteur;
	}

	public Topo getTopoCommente() {
		return topoCommente;
	}

	public void setTopoCommente(Topo topoCommente) {
		this.topoCommente = topoCommente;
	}

	public Site getSiteCommente() {
		return siteCommente;
	}

	public void setSiteCommente(Site siteCommente) {
		this.siteCommente = siteCommente;
	}
	
	
	
}
