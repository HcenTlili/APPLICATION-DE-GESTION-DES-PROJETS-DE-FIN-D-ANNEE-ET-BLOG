package com.enit.projects.testjee.entities;

import java.util.List;

public class Combinaison {
	
	public Combinaison(Post post, List<Commentaire> listeCommentaires) {
		super();
		this.post = post;
		this.listeCommentaires = listeCommentaires;
	}
	private Post post;
	private List<Commentaire> listeCommentaires;
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}
	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}
	

}
