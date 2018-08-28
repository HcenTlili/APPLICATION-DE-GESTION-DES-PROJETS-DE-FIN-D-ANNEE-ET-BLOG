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
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;
import com.enit.projects.testjee.metierImplementation.DAOEnseignantImplementation;
import com.enit.projects.testjee.metierImplementation.DAOEtudiantImplementation;

public class testServlet extends HttpServlet {
	    
	
	    
	    
	@EJB
	DAOEtudiant d ;
	
	@EJB
	DAOEnseignant dd ;
	
	
	
	
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
				String f= request.getParameter("identifiant");
				ResultSet listePFEAencadrer= (ResultSet) s.executeQuery("SELECT idPFE,description FROM PFE where enseignant_IDProffesseur="+f);
				List<PFE> listepfeaencadrer = new LinkedList<>();
				while (listePFEAencadrer.next()) {
					
					
					  String i = listePFEAencadrer.getString("idPFE");
					  String str = listePFEAencadrer.getString("description");
					  
					  
					  //Assuming you have a user object
					  PFE pfe = new PFE(i,str);

					  
						listepfeaencadrer.add(pfe);
					
				}
				
				HttpSession session = request.getSession(true); 
			session.setAttribute("identifiant",(String)request.getParameter("identifiant"));
				session.setAttribute("listePFE", liste);
				session.setAttribute("listePFA", liste1);
				session.setAttribute("listepfeaencadrer", listepfeaencadrer);
				con.close();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
		   
		   
		   /*List<PFE> listePFE = dd.listePFE();
		   HttpSession session = request.getSession(true); 
			session.setAttribute("listePFE", listePFE);*/
		   
		   
		   
			
				long identifiant;
				try {
					int ident =Integer.parseInt(request.getParameter("identifiant")) ;
					identifiant = (long)ident;
				
				   String login = request.getParameter("loginuser");
				   String motDePasse = request.getParameter("mdpuser");
				   
				   RequestDispatcher dispatcher = null;
				   
				   if(dd.verifierExistenceEnseignant(identifiant,login, motDePasse))
				   {
				   dispatcher=request.getRequestDispatcher("acceuilEnseignant.jsp");
				   dispatcher.forward(request, response);
				   }
				   else{if(d.verifierExistenceEtudiant(identifiant, login, motDePasse))
				   {				   dispatcher=request.getRequestDispatcher("acceuilEtudiant.jsp");
				   dispatcher.forward(request, response);
					   
				   }
				   else{
					   dispatcher=request.getRequestDispatcher("index.html");
					   dispatcher.forward(request, response);
				   }}
				} catch (NullPointerException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
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
