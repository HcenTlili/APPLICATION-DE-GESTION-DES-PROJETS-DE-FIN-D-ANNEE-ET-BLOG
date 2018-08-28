package com.enit.projects.testjee.metier;

import java.util.List;

import javax.ejb.Local;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;


@Local
public interface DAOEnseignant {
	
	
	
	public void ajouterPFA(PFA pfa);
	public void choisirPFE(PFE pfe,Enseignant e);
	public List<PFE> listePFE();
	public boolean verifierPFA(long a);
	public void ajouterEnseignant(Enseignant enseignant);
	
	public boolean verifierExistenceEnseignant(long identifiant, String login, String motDePasse);
	
	
	

}
