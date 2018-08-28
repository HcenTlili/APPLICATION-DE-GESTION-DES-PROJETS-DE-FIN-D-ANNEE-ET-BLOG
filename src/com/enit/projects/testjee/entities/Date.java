package com.enit.projects.testjee.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Date {
	
	
	public Date() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date(int jour, int mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}
	
	private int jour;
	private int mois;
	private int annee;
	@Id
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	

}
