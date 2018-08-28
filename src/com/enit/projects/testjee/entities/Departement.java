package com.enit.projects.testjee.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.Specialite;
@Entity
public class Departement {
	@Id
	private String nomDepartement;
	
	
	
	@OneToMany
	private Collection<Etudiant> listeEtudiants;
	
	@OneToMany
	private Collection<Enseignant> listeEnseignant;
	
	
	@OneToMany
	private Collection<Specialite> listeSpecialites;

	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(String nomDepartement, Collection<Enseignant> listeEnseignant,
			Collection<Etudiant> listeEtudiants, Collection<Specialite> listeSpecialites) {
		super();
		this.nomDepartement = nomDepartement;
		this.listeEnseignant = listeEnseignant;
		this.listeEtudiants = listeEtudiants;
		this.listeSpecialites = listeSpecialites;
	}
	
	
	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public Collection<Enseignant> getListeEnseignant() {
		return listeEnseignant;
	}

	public void setListeEnseignant(Collection<Enseignant> listeEnseignant) {
		this.listeEnseignant = listeEnseignant;
	}

	public Collection<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(Collection<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

	public Collection<Specialite> getListeSpecialites() {
		return listeSpecialites;
	}

	public void setListeSpecialites(Collection<Specialite> listeSpecialites) {
		this.listeSpecialites = listeSpecialites;
	}
	
	

}
