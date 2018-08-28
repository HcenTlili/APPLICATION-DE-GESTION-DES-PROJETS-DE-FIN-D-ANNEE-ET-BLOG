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
import com.enit.projects.testjee.metierImplementation.DAOEtudiantImplementation;

public class ajoutPfaServlet extends HttpServlet {
	@EJB
	DAOEnseignant d ;
	
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
				
		   String identifiantPFA= request.getParameter("identifiantPfa");
		   String description = request.getParameter("descriptionPfa");
		   
		   PFA pfa =new PFA(identifiantPFA,description);
		   
		   d.ajouterPFA(pfa);
		   String f=(String)request.getParameter("identifiant") ;
			
			
			ResultSet listePFEAencadrer= (ResultSet) s.executeQuery("SELECT idPFE,description FROM PFE where enseignant_IDProffesseur="+f);
			System.out.println("hcennnn"+f+"hcennnnnnn");
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
			con.close();
		   
		   
		   RequestDispatcher dispatcher = null;
		   dispatcher=request.getRequestDispatcher("acceuilEnseignant.jsp");
		   dispatcher.forward(request, response);
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
	
	
	


