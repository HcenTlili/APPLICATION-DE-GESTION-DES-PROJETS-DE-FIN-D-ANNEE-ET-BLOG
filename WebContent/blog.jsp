<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import ="java.io.IOException" %>
<%@page import = "javax.servlet.ServletException"%>
<%@page import= "javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="com.enit.projects.testjee.entities.PFE"%>
<%@page import="com.enit.projects.testjee.entities.Post"%>
<%@page import="com.enit.projects.testjee.entities.Combinaison"%>
<%@page import="java.util.*" %>
<%@page import = "javax.ejb.EJB" %>

<% try{
LinkedList<Post> liste1 = (LinkedList<Post>)session.getAttribute("listePost");
LinkedList<Combinaison> liste2 = (LinkedList<Combinaison>)session.getAttribute("lesCombinaisons");
int i; %>
 
 
<% for(i=0;i<liste1.size();i++){%> 
<label><% out.println(liste2.get(i).getPost().getIdentifiant()); %>    </label> 
<label><% out.println(liste2.get(i).getPost().getContenu()); %>    </label> 

  <label><% out.println(liste2.get(i).getPost().getLink()); %>    </label> 

<% for(int q=0;q<liste2.get(i).getListeCommentaires().size();q++){%> 
<label><% out.println(liste2.get(i).getListeCommentaires().get(q).getContenu()); %>    </label> </br>
<% } %>
<form id="ajoutcommentaireform" action="ajoutCommentaireServlet">
<label> Date</label></br>
<label> jour:</label><input type ="text" name="jourCommentaire"><label> mois:</label><input type ="text" name="moisCommentaire"><label> annee:</label><input type ="text" name="anneeCommentaire"></br>
<label> Contenu:</label><input type ="text" name="contenuCommentaire"></br>
<label>id post:</label><input type="text" name="idpostcomment">

<input type="submit" value="Ajouter commentaire">
</form>

<% }} catch (NullPointerException ee) {
	// TODO Auto-generated catch block
	ee.printStackTrace();
} %> 


<form id="ajoutpostform" action="ajoutPostServlet">
<label> Date</label></br>
<label> jour:</label><input type ="text" name="jourPost"><label> mois:</label><input type ="text" name="moisPost"><label> annee:</label><input type ="text" name="anneePost"></br>
<label> Contenu:</label><input type ="text" name="contenuPost"></br>
<label> Lien:</label><input type ="text" name="lienPost"></br>
<label> ID Post:</label><input type ="text" name="idPost"></br>

<input type="submit" value="Ajouter post ">
</form>



</form>
</body>
</html>