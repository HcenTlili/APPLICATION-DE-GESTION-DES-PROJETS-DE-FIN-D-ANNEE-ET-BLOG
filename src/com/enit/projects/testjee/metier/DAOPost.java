package com.enit.projects.testjee.metier;

import java.util.List;

import javax.ejb.Local;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;
import com.enit.projects.testjee.entities.Post;


@Local
public interface DAOPost {
	
	
	
	public void ajouterPost(Post post);
	
	
	








	public Post trouverPost(int ident);
	


	

}
