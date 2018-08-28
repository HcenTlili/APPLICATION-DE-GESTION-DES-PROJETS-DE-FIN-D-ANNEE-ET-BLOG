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
import com.enit.projects.testjee.entities.Post;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;
import com.enit.projects.testjee.metier.DAOPost;


@Stateless
public class DAOPostImplementation implements DAOPost{

	@EJB
	private DAOEtudiant D;
	
	
	
	@PersistenceContext(name="projectDS")
	EntityManager emm;
	
	






	public void ajouterPost(Post post) {
		// TODO Auto-generated method stub
		emm.persist(post);
	}
	
	public Post trouverPost(int ident) {
		// TODO Auto-generated method stub
		Post p = emm.find(Post.class,ident);
		return p;
	}

}
