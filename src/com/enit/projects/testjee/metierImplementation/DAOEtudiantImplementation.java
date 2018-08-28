package com.enit.projects.testjee.metierImplementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;

@Stateless
public class DAOEtudiantImplementation implements DAOEtudiant{

	@EJB
	private DAOEtudiant D;
	
	
	
	@PersistenceContext(name="projectDS")
	EntityManager emm;
	
	
	@Override
	public void ajouterPFE(PFE pfe) {
		// TODO Auto-generated method stub
			emm.persist(pfe);
	}

	

	
	public List<PFA> listePFA() {
		// TODO Auto-generated method stub
		return null;
		
		
	}
	
	@Override
	public void ajouterEtudiant(Etudiant ee)
	{
		emm.persist(ee);
	}



	
	public boolean verifierExistenceEtudiant(long identifiant, String login, String motDePasse) {
		// TODO Auto-generated method stub
		Etudiant ee = emm.find(Etudiant.class,identifiant);
		
		if((ee!=null)&&(ee.getLogin().equalsIgnoreCase(login))&&(ee.getPwd().equalsIgnoreCase(motDePasse)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	




	@Override
	public PFA trouverPfa(String a) {
PFA p=emm.find(PFA.class, a);
		
		return p;
	}



	public Etudiant trouverEtudiant(long identifiantEtudiant) {
Etudiant e=emm.find(Etudiant.class, identifiantEtudiant);
		
		return e;
	}

}
