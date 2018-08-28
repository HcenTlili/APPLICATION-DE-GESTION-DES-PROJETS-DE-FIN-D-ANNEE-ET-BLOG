package com.enit.projects.testjee.metierImplementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;
import com.enit.projects.testjee.metier.DAOEnseignant;
import java.sql.Connection;
import java.sql.Statement;
@Stateless
public class DAOEnseignantImplementation implements DAOEnseignant {

@EJB
private DAOEnseignant dd;
	
	
@PersistenceContext(name="projectDS")
EntityManager em;

@Override
public void ajouterEnseignant(Enseignant e)
{
	em.persist(e);
}

@Override
public void ajouterPFA(PFA pfa) {
	// TODO Auto-generated method stub
	em.persist(pfa);
}

@Override
public void choisirPFE(PFE pfe,Enseignant e) {
	// TODO Auto-generated method stub
	
	// pfe.setEnseignant(e);
	em.persist(pfe);
	
	
	
}

public boolean verifierPFA(long a)
{
	if(em.find(PFA.class, a)!=null)
	{
		return true;
	}
	else return false;
	
}


@Override
public List<PFE> listePFE() {
	// TODO Auto-generated method stub
	List<PFE> LISTE =(List<PFE>) em.createQuery("Select * from PFA");
	return LISTE;
}

public boolean verifierExistenceEnseignant(long a, String aa ,String b)
{
	/*Connection cc ;
	Statement ss = cc.createStatement();
	
	Enseignant rs;
	rs=ss.executeQuery("select * from personnel where MATRICULE ="+a+" and PASSE="+b+"");*/
	
		Enseignant ee = em.find(Enseignant.class,a);
	
		if((ee!=null)&&(ee.getLogin().equalsIgnoreCase(aa))&&(ee.getPwd().equalsIgnoreCase(b)))
		{
			return true;
		}
		else
		{
			return false;
		}
	
}



	
	
	
	
	
	
	

}
