package com.enit.projects.testjee.metier;

import java.util.List;

import javax.ejb.Local;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;


@Local
public interface DAOEtudiant {
	
	
	
	public void ajouterPFE(PFE pfe);
	
	public List<PFA> listePFA();
	public void ajouterEtudiant(Etudiant ee);

	public boolean verifierExistenceEtudiant(long identifiant, String login, String motDePasse);
	public PFA trouverPfa(String a);
	

	


	public Etudiant trouverEtudiant(long identifiantEtudiant);

	

	

	


	
	
	

}
