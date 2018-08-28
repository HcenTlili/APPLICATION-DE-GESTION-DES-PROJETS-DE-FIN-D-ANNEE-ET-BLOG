package com.enit.projects.testjee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metierImplementation.DAOEnseignantImplementation;
import com.enit.projects.testjee.metierImplementation.DAOEtudiantImplementation;

public class Test extends HttpServlet {
	    
	
	    
	    
	@EJB
	DAOEtudiantImplementation d ;
	
	   @SuppressWarnings("null")
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		    
		   

			
			
			long c= 0;
			
			
			String a ="aaa";
			String b="bbb";
			Etudiant etudiant=new Etudiant(c, a, b);
			d.ajouterEtudiant(etudiant);
			/*Etudiant etudiant=new Etudiant(1,"eee","jjj");
			String description="dd";
			long idPFA=1;
			PFA p =new PFA();
			p.setDescription(description);
		
			p.setIdPFA(idPFA);
			PFA pp =new PFA();
			pp.setDescription("zz");
		
			pp.setIdPFA(2);
		d.ajouterPFA(pp);
		 System.out.println(d.verifierPFA(2));
		
			
		   
		   response.setContentType("text/html");

		    response.setCharacterEncoding( "UTF-8" );

		    PrintWriter out = response.getWriter();

		    out.println("<!DOCTYPE html>");

		    out.println("<html>");

		    out.println("<head>");

		    out.println("<meta charset=\"utf-8\" />");

		    out.println("<title>Test</title>");

		    out.println("</head>");

		    out.println("<body>");

		    out.println("<p>Ceci est une page générée depuis une servlet.</p>");

		    out.println("</body>");

		    out.println("</html>");*/

	    }

}
