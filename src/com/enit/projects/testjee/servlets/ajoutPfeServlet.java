package com.enit.projects.testjee.servlets;

import java.beans.Statement;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;
import com.enit.projects.testjee.metierImplementation.DAOEtudiantImplementation;

public class ajoutPfeServlet extends HttpServlet {
	@EJB
	DAOEtudiant d ;
	
	
	   @SuppressWarnings("null")
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		    
		 
		   String identifiantPFE= request.getParameter("identifiantPfe");
		   String description = request.getParameter("descriptionPfe");
		   
		   PFE pfe =new PFE(identifiantPFE,description);
		   
		   d.ajouterPFE(pfe);
		   
		   
		   RequestDispatcher dispatcher = null;
		   dispatcher=request.getRequestDispatcher("acceuilEtudiant.jsp");
		   dispatcher.forward(request, response);

	    
	   

}}
	
	
	



