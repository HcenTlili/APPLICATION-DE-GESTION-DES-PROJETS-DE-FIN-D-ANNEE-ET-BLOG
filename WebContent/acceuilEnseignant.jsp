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

<%@page import="java.util.List" %>
<%@page import = "javax.ejb.EJB" %>


<label>Mon identifiant:</label><label><% out.println(session.getAttribute("identifiant")); %></label>
<form id="ajoutform" action="ajoutPfaServlet">
<label> identifiant Enseignant :</label>
<input type ="text" name="identifiant">
<label> identifiant PFA :</label>
<input type ="text" name="identifiantPfa">
<label> description PFA :</label>
<input type ="text" name="descriptionPfa">

<input type="submit" value="Ajouter PFA">
</form>




<table border="1"> 
  
<tr> 
 
<th>ID PFE</th> 
<th>DESCRIPTION</th> 
</tr> 
<% try{
List<PFE> liste = (List<PFE>)session.getAttribute("listePFE");

int i; %>
 
 
<% for(i=0;i<liste.size();i++){%> 
<tr> 
 <td><% out.println(liste.get(i).getIdPFE()); %>    </td> 

  <td><% out.println(liste.get(i).getDescription()); %>    </td> 

<% }} catch (NullPointerException ee) {
	// TODO Auto-generated catch block
	ee.printStackTrace();
} %> 
</tr>
</table>

<form id="choixformEnseignant" action="choixPfeServlet">
<label> identifiant Enseignant :</label>
<input type ="text" name="identifiantChoixEnseignant">
<label> identifiant Pfe :</label>
<input type ="text" name="identifiantChoixPfe">

<input type="submit" value="Choisir PFE">
</form>
<H1>LES PFE CHOISIS POUR ENCADRER</H1>
<table border="1"> 
  
<tr> 
 
<th>ID PFE</th> 
<th>DESCRIPTION</th> 
</tr> 
<% try{
	List<PFE> listepfeaencadrer = (List<PFE>)session.getAttribute("listepfeaencadrer");

int i; %>
 
 
<% for(i=0;i<listepfeaencadrer.size();i++){%> 
<tr> 
 <td><% out.println(listepfeaencadrer.get(i).getIdPFE()); %>    </td> 

  <td><% out.println(listepfeaencadrer.get(i).getDescription()); %>    </td> 

<% }} catch (NullPointerException ee) {
	// TODO Auto-generated catch block
	ee.printStackTrace();
} %> 
</tr>
</table>

</body>

</html>