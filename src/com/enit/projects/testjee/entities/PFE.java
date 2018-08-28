package com.enit.projects.testjee.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PFE {
	
	
	public PFE() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PFE(String identifiantPFE, String description2) {
		// TODO Auto-generated constructor stub
		super();
		this.idPFE = identifiantPFE;
		this.description = description2;
	}


	@Id
	private String idPFE;
	private String description;
	@OneToOne
	private Enseignant enseignant;
	
	
	
	
	public String getIdPFE() {
		return idPFE;
	}
	public void setIdPFE(String idPFE) {
		this.idPFE = idPFE;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	

}
