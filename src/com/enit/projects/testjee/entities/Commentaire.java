package com.enit.projects.testjee.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Commentaire {

	
	public Commentaire(Date date, String contenu, Post post) {
		super();
		this.date = date;
		this.contenu = contenu;
		this.post = post;
	}
	public Commentaire(Date date, Etudiant auteur, String contenu) {
		super();
		this.date = date;
		this.auteur = auteur;
		this.contenu = contenu;
	}
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commentaire(Date date, String contenu) {
		super();
		this.date = date;
		this.contenu = contenu;
	}
	
	public Commentaire(String contenuCommentaire, Post postcomment1) {
		// TODO Auto-generated constructor stub
		this.contenu=contenuCommentaire;
		this.post=postcomment1;
	}

	@OneToOne
	private Date date;
	@OneToOne
	private Etudiant auteur;
	@Id
	private String contenu;
	@ManyToOne
	private Post post;
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
	public Etudiant getAuteur() {
		return auteur;
	}
	public void setAuteur(Etudiant auteur) {
		this.auteur = auteur;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
