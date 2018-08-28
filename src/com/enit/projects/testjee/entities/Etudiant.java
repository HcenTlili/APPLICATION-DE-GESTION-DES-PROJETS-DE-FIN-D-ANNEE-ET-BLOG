package com.enit.projects.testjee.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etudiant implements Serializable{
	
	public Etudiant(long iDEtudiant, String login, String pwd, String role) {
		super();
		IDEtudiant = iDEtudiant;
		this.login = login;
		this.pwd = pwd;
		this.role = role;
	}

	@Id
	private long IDEtudiant;
	private String login;
	private String pwd;
	private String role;
	public Etudiant() {
		super();
	}

	public Etudiant(long IDEtudiant,String login, String pwd) {
		super();
		this.IDEtudiant=IDEtudiant;
		this.login = login;
		this.pwd = pwd;
	}
	public long getIDEtudiant(){
		return IDEtudiant;
	}
	public void setIDEtudiant(long id){
		this.IDEtudiant=id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (IDEtudiant ^ (IDEtudiant >>> 32));
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
		Etudiant other = (Etudiant) obj;
		if (IDEtudiant != other.IDEtudiant)
			return false;
		return true;
	}

}