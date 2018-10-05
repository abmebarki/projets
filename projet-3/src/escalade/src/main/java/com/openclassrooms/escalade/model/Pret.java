package com.openclassrooms.escalade.model;

import java.util.Date;

/**
 * Objet métier représentant un prét d'un topo
 *
 * @author amebarki
 */

public class Pret {
	
	// ==================== Attributs ====================
	private Integer id;
	private Grimpeur emprunteur;
	private Topo topoEmprunte;
	private Date dateDebut;
	private Date dateFin;
	
	
    // ==================== Constructeurs ====================
	 /**
     * Constructeur par défaut.
     */
	public Pret() {
	}

	public Pret(Integer id) {
		super();
		this.id = id;
	}
	
	// ==================== Getters/Setters ====================
	
	public Grimpeur getEmprunteur() {
		return emprunteur;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setEmprunteur(Grimpeur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Topo getTopoEmprunte() {
		return topoEmprunte;
	}


	public void setTopoEmprunte(Topo topoEmprunte) {
		this.topoEmprunte = topoEmprunte;
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
