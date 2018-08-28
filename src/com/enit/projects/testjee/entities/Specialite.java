package com.enit.projects.testjee.entities;
import com.enit.projects.testjee.entities.Enseignant;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Specialite {
	public Specialite(String nomSpecialtite, List<Enseignant> listeEnseignant) {
		super();
		this.nomSpecialtite = nomSpecialtite;
		this.listeEnseignant = listeEnseignant;
	}




	

	@Id
	private String nomSpecialtite;
	
	
	@OneToMany
	private List<Enseignant> listeEnseignant;
	
	
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public String getNomSpecialtite() {
		return nomSpecialtite;
	}

	public void setNomSpecialtite(String nomSpecialtite) {
		this.nomSpecialtite = nomSpecialtite;
	}




	public List<Enseignant> getListeEnseignant() {
		return listeEnseignant;
	}




	public void setListeEnseignant(List<Enseignant> listeEnseignant) {
		this.listeEnseignant = listeEnseignant;
	}

	
	

	
	

}
