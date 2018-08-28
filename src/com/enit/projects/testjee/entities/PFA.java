package com.enit.projects.testjee.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PFA {
	
	/*public PFA(long idPFA, String description, Enseignant enseignant, Etudiant etudiant) {
		super();
		this.idPFA = idPFA;
		this.description = description;
		this.enseignant = enseignant;
		this.etudiant = etudiant;
	}*/


	

	public PFA(String identifiantPFA, String description2) {
		// TODO Auto-generated constructor stub
		this.idPFA=identifiantPFA;
		this.description=description2;
	}

	

	@Id
	private String idPFA;
	private String description;
	
	
	@OneToOne
	private Etudiant etudiant ;
	


	public String getIdPFA() {
		return idPFA;
	}


	public void setIdPFA(String idPFA) {
		this.idPFA = idPFA;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	


	
	
	


}
