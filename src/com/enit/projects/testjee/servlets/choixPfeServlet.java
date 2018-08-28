package com.enit.projects.testjee.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
import com.sun.org.apache.bcel.internal.generic.DDIV;

public class choixPfeServlet extends HttpServlet {
	@EJB
	DAOEtudiant d ;
	
	   @SuppressWarnings("null")
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		   
			   
		   
		   String identifiantPFE= request.getParameter("identifiantChoixPfe");
		 
		   
		   long identifiantEnseignant;
				int ident =Integer.parseInt(request.getParameter("identifiantChoixEnseignant")) ;
				identifiantEnseignant = (long)ident;
				
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
					
			//		Etudiant e =d.trouverEtudiant(identifiantEtudiant);
					 s.executeUpdate("UPDATE PFE SET enseignant_IDProffesseur="+identifiantEnseignant +" WHERE idPFE="+identifiantPFE);
					
					 String f= (String)request.getParameter("identifiant");
						ResultSet listePFEAencadrer= (ResultSet) s.executeQuery("SELECT idPFE,description FROM PFE where enseignant_IDProffesseur="+identifiantEnseignant);
						List<PFE> listepfeaencadrer = new LinkedList<>();
						while (listePFEAencadrer.next()) {
							
							
							  String i = listePFEAencadrer.getString("idPFE");
							  String str = listePFEAencadrer.getString("description");
							  
							  
							  //Assuming you have a user object
							  PFE pfe = new PFE(i,str);

							  
								listepfeaencadrer.add(pfe);
							
						}
						
						HttpSession session = request.getSession(true); 
						
						session.setAttribute("listepfeaencadrer", listepfeaencadrer);
				
		   
		   RequestDispatcher dispatcher = null;
		   dispatcher=request.getRequestDispatcher("acceuilEnseignant.jsp");
		   dispatcher.forward(request, response);
				   } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    }
	   
}