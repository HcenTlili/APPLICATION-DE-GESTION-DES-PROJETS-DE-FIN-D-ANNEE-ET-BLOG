package com.enit.projects.testjee.entities;

import java.io.Serializable;
import java.util.List;

import javax.jws.Oneway;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Enseignant implements Serializable{
	

	
	

	



	
	@Id
	private long IDProffesseur;
	
	
	private String login;
	private String pwd;
	private String role;
	
	
	
	

	public Enseignant() {
		super();
	}

	
	
	public Enseignant(long identifiant, String login2, String motDePasse, String role2) {
		// TODO Auto-generated constructor stub
		super();
		IDProffesseur = identifiant;
		this.login = login2;
		this.pwd = motDePasse;
		this.role=role2;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public long getIDProffesseur() {
		return IDProffesseur;
	}

	public void setIDProffesseur(long iDProffesseur) {
		IDProffesseur = iDProffesseur;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (IDProffesseur ^ (IDProffesseur >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignant other = (Enseignant) obj;
		if (IDProffesseur != other.IDProffesseur)
			return false;
		return true;
	}

	
	

}