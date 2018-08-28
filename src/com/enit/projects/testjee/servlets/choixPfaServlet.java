package com.enit.projects.testjee.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;
import com.enit.projects.testjee.metierImplementation.DAOEtudiantImplementation;
import com.sun.org.apache.bcel.internal.generic.DDIV;

public class choixPfaServlet extends HttpServlet {
	@EJB
	DAOEtudiant d ;
	
	   @SuppressWarnings("null")
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		   
			   
		   
		   String identifiantPFA= request.getParameter("identifiantChoixPfa");
		 
		   System.out.println("hcennnnnnnnnnnn");
		   long identifiantEtudiant;
				int ident =Integer.parseInt(request.getParameter("identifiantChoixEtudiant")) ;
				identifiantEtudiant = (long)ident;
				
				 Connection con = null;
				 try {
				   
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   try {
					con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/base2","root","hcentlili");
				
				   
				   
				   
					java.sql.Statement s;
					
						s = con.createStatement();
					
					Etudiant e =d.trouverEtudiant(identifiantEtudiant);
					 s.executeUpdate("UPDATE PFA SET etudiant_IDEtudiant="+identifiantEtudiant +" WHERE idPFA="+identifiantPFA);
				
				
		   
		   RequestDispatcher dispatcher = null;
		   dispatcher=request.getRequestDispatcher("acceuilEtudiant.jsp");
		   dispatcher.forward(request, response);
				   } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    }
	   
}