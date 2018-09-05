package com.openclassrooms.escalade.model;

import java.util.Date;

/**
 * Objet m�tier repr�sentant un pr�t d'un topo
 *
 * @author amebarki
 */

public class Pret {
	
	// ==================== Attributs ====================
	private Grimpeur emprunteur;
	private Topo topoPrete;
	private Date dateDebut;
	private Date dateFin;
	
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par d�faut.
     */
	public Pret() {
	}

	
	// ==================== Getters/Setters ====================
	public Grimpeur getEmprunteur() {
		return emprunteur;
	}


	public void setEmprunteur(Grimpeur emprunteur) {
		this.emprunteur = emprunteur;
	}


	public Topo getTopoPrete() {
		return topoPrete;
	}


	public void setTopoPrete(Topo topoPrete) {
		this.topoPrete = topoPrete;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
		
	
	
		
	
	
}
