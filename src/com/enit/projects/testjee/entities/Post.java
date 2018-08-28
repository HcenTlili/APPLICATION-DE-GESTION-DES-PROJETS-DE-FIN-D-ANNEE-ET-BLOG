package com.enit.projects.testjee.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Post {
	
	
	
	

	public Post(Date date, String contenu, String link, Etudiant auteur) {
		super();
		this.date = date;
		this.contenu = contenu;
		this.link = link;
		this.auteur = auteur;
		
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Date date, String contenu, String link) {
		super();
		this.date = date;
		this.contenu = contenu;
		this.link = link;
		
	}
	public Post(String i, String str) {
		// TODO Auto-generated constructor stub
		this.contenu=i;
		this.link=str;
	}
	public Post(int ident, String contenuPost, String lienPost) {
		// TODO Auto-generated constructor stub
		this.identifiant=ident;
		this.contenu=contenuPost;
		this.link=lienPost;
	}
	@OneToOne
	private Date date;
	private String contenu ;
	private String link="";
	@Id
	private int identifiant;
	@OneToOne
	private Etudiant auteur;
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

}
