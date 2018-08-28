package com.enit.projects.testjee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.enit.projects.testjee.entities.Combinaison;
import com.enit.projects.testjee.entities.Commentaire;
import com.enit.projects.testjee.entities.Enseignant;
import com.enit.projects.testjee.entities.Etudiant;
import com.enit.projects.testjee.entities.PFA;
import com.enit.projects.testjee.entities.PFE;
import com.enit.projects.testjee.entities.Post;
import com.enit.projects.testjee.entities.Specialite;
import com.enit.projects.testjee.metier.DAOCommentaire;
import com.enit.projects.testjee.metier.DAOEnseignant;
import com.enit.projects.testjee.metier.DAOEtudiant;
import com.enit.projects.testjee.metier.DAOPost;
import com.enit.projects.testjee.metierImplementation.DAOEnseignantImplementation;

public class ajoutCommentaireServlet extends HttpServlet {
	    
	
	    
	    
	@EJB
	DAOPost d ;
	
	@EJB
	DAOCommentaire ddd;
	
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
   String contenuCommentaire= request.getParameter("contenuCommentaire");
   int ident =Integer.parseInt(request.getParameter("idpostcomment")) ;
/*   ResultSet postcomment= (ResultSet) s.executeQuery("SELECT contenu,link FROM Post where identifiant="+ident);
   List<Post> listeprime = new LinkedList<>();
   while (postcomment.next()) {
   listeprime=postcomment.getString("")
   }*/
   Post postcherche=d.trouverPost(ident);
   Commentaire commentaire1=new Commentaire(contenuCommentaire,postcherche);
   
   ddd.ajouterCommentaire(commentaire1);
   
		
		
		ResultSet listePost= (ResultSet) s.executeQuery("SELECT identifiant,contenu,link FROM Post");
		List<Post> liste = new LinkedList<>();
		
		
		
		while (listePost.next()) {
			
			int a = Integer.parseInt(listePost.getString("identifiant"));
			  String i = listePost.getString("contenu");
			  String str = listePost.getString("link");
			  Post post = new Post(a,i,str);
			  liste.add(post);
			  
			 }
		ResultSet listeCommentaires= (ResultSet) s.executeQuery("SELECT contenu,post_identifiant FROM Commentaire");
		List<Commentaire> lesCommentaires=new LinkedList<>();
		
		
		
		
		
	/*	while (listePost.next()) {
			
			int a = Integer.parseInt(listePost.getString("identifiant"));
			  String i = listePost.getString("contenu");
			  String str = listePost.getString("link");
			  Post post = new Post(a,i,str);
			  liste.add(post);
			  
			 }*/
while (listeCommentaires.next()) {
			
			int a = Integer.parseInt(listeCommentaires.getString("post_identifiant"));
			  String i = listeCommentaires.getString("contenu");
			  
			  Post postcherchee=d.trouverPost(a);
			   Commentaire commentaire2=new Commentaire(i,postcherchee);
			   lesCommentaires.add(commentaire2);
			 }
		List<Combinaison> lesCombinaisons=new LinkedList<Combinaison>();
	for(int o=0;o<liste.size();o++)
	{
		List<Commentaire> L=new ArrayList<Commentaire>();
	
		
		for(int z=0;z<lesCommentaires.size();z++)
		{
			if(lesCommentaires.get(z).getPost().getIdentifiant()==liste.get(o).getIdentifiant())
			{
				L.add(lesCommentaires.get(z));
			}
		}
		Combinaison c = new Combinaison(liste.get(o),L);
		lesCombinaisons.add(c);
	}
		
		
		HttpSession session = request.getSession(true); 
		session.setAttribute("listePost", liste);
		session.setAttribute("lesCombinaisons",lesCombinaisons);
		con.close();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = null;
		   dispatcher=request.getRequestDispatcher("blog.jsp");
		   dispatcher.forward(request, response);
   
   
   
   
   
   
   
  
			  
			   
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				   
				   
				 
				   
				  
				 
				   
				   
				   
				   
				   
				   
				
			
		   
		   
		   

			
			

	    }

}
