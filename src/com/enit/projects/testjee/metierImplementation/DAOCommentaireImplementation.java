package com.enit.projects.testjee.metierImplementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.enit.projects.testjee.entities.Commentaire;
import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;
import com.enit.projects.testjee.entities.Post;
import com.enit.projects.testjee.metier.DAOCommentaire;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;
import com.enit.projects.testjee.metier.DAOPost;


@Stateless
public class DAOCommentaireImplementation implements DAOCommentaire{

	@EJB
	private DAOCommentaire D;
	
	
	
	@PersistenceContext(name="projectDS")
	EntityManager emm;
	
	






	public void ajouterCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		emm.persist(commentaire);
	}

}
