package com.enit.projects.testjee.test;

import javax.ejb.EJB;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.metierImplementation.DAOEnseignantImplementation;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DAOEnseignantImplementation d;
		d=new DAOEnseignantImplementation();
		
		long c= 0;
		
		System.out.println("hcen");
		String a ="aaa";
		String b="bbb";
	//	Enseignant enseignant=new Enseignant(c, a, b);
		Etudiant etudiant=new Etudiant(1,"eee","jjj");
		String description="dd";
		long idPFA=1;
	//	PFA p =new PFA(idPFA, description);
		
	//	d.ajouterPFA(p);

	}

}
