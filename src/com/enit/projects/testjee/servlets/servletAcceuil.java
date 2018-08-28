package com.enit.projects.testjee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;
import com.enit.projects.testjee.entities.Specialite;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;
import com.enit.projects.testjee.metierImplementation.DAOEnseignantImplementation;

public class servletAcceuil extends HttpServlet {
	    
	
	    
	    
	@EJB
	DAOEnseignant d ;
	
	@EJB
	DAOEtudiant dd ;
	
	   @SuppressWarnings("null")
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		    
		   try {
			   try {
		   String url="jdbc:mysql://localhost:3306/base2";
		   String m="";
		   String u="hcentlili";
		   Connection con = null;
		 
		   Class.forName("com.mysql.jdbc.Driver");
		   con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/base2","root","hcentlili");
		   
		   
		   
			java.sql.Statement s =con.createStatement();
			
			ResultSet listePFE= (ResultSet) s.executeQuery("SELECT idPFE,description FROM PFE");
			List<PFE> liste = new LinkedList<>();
			
			
			try {
			while (listePFE.next()) {
				
				
				  String i = listePFE.getString("idPFE");
				  String str = listePFE.getString("description");
				  
				  
				  //Assuming you have a user object
				  PFE pfe = new PFE(i,str);

				  
					liste.add(pfe);
				
			}
			ResultSet listePFA= (ResultSet) s.executeQuery("SELECT idPFA,description FROM PFA");
			List<PFA> liste1 = new LinkedList<>();
			while (listePFA.next()) {
				
				
				  String i = listePFA.getString("idPFA");
				  String str = listePFA.getString("description");
				  
				  
				  //Assuming you have a user object
				  PFA pfa = new PFA(i,str);

				  
					liste1.add(pfa);
				
			}
			
			
			
			HttpSession session = request.getSession(true); 
			session.setAttribute("identifiant",(String)request.getParameter("identifiantregister"));
			session.setAttribute("listePFE", liste);
			session.setAttribute("listePFA", liste1);
			con.close();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				
		   
		   
		   
		   
		   
		   
		   
		   long identifiant;
				
				int ident =Integer.parseInt(request.getParameter("identifiantregister")) ;
					identifiant = (long)ident;
				
				   String login = request.getParameter("loginuserregister");
				   String motDePasse = request.getParameter("mdpuserregister");
				   String role = request.getParameter("roleuserregister");
				   RequestDispatcher dispatcher = null;
				   if(role.equalsIgnoreCase("Enseignant"))
				   {
					   Enseignant e = new Enseignant(identifiant, login, motDePasse,role);
					   if(d.verifierExistenceEnseignant(identifiant,login, motDePasse))
					   {
					   dispatcher=request.getRequestDispatcher("index.html");
					   dispatcher.forward(request, response);
					   }
					   else
					   {
						   d.ajouterEnseignant(e);
						   dispatcher=request.getRequestDispatcher("acceuilEnseignant.jsp");
						   dispatcher.forward(request, response);
					   }
				   }
				   
				   if(role.equalsIgnoreCase("Etudiant"))
				   {
					   Etudiant ee = new Etudiant(identifiant, login, motDePasse,role);
					   if(dd.verifierExistenceEtudiant(identifiant,login, motDePasse))
					   {
					   dispatcher=request.getRequestDispatcher("index.html");
					   dispatcher.forward(request, response);
					   }
					   else
					   {
						   dd.ajouterEtudiant(ee);
						   dispatcher=request.getRequestDispatcher("acceuilEtudiant.jsp");
						   dispatcher.forward(request, response);
						   
					   }
				   }
				 
				  
				   
			   } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				   } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
				   
				 
				   
				  
				 
				   
				   
				   
				   
				   
				   
				
			
		   
		   
		   

			
			

	    }

}
