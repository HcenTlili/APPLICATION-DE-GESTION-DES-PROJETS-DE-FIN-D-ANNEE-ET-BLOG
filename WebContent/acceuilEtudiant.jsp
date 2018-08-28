<%@page import="java.util.LinkedList"%>
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
<%@page import="com.enit.projects.testjee.entities.PFA"%>
<%@page import="com.enit.projects.testjee.entities.PFE"%>
<%@page import="java.util.List" %>
<%@page import = "javax.ejb.EJB" %>

<label>Mon identifiant:</label><label><% out.println(session.getAttribute("identifiant")); %></label>

<form id="ajoutform" action="ajoutPfeServlet">
<label> identifiant PFE :</label>
<input type ="text" name="identifiantPfe">
<label> description PFE :</label>
<input type ="text" name="descriptionPfe">

<input type="submit" value="Ajouter PFE">
</form>


<table border="1"> 
  
<tr> 
 
<th>idPFA</th> 
<th>Description</th> 
</tr> 
<% try{
LinkedList<PFA> liste1 = (LinkedList<PFA>)session.getAttribute("listePFA");

int i; %>
 
 
<% for(i=0;i<liste1.size();i++){%> 
<tr> 
 <td><% out.println(liste1.get(i).getIdPFA()); %>    </td> 

  <td><% out.println(liste1.get(i).getDescription()); %>    </td> 
</tr>
<% }} catch (NullPointerException ee) {
	// TODO Auto-generated catch block
	ee.printStackTrace();
} %> 

</table>


<form id="choixform" action="choixPfaServlet">
<label> identifiant Etudiant :</label>
<input type ="text" name="identifiantChoixEtudiant">
<label> identifiant Pfa :</label>
<input type ="text" name="identifiantChoixPfa">

<input type="submit" value="Choisir PFA">
</form>
</table>


<form id="passageform" action="affichageInitialServlet">
<input type="submit" value="Aller au blog">
</form>

</body>

</html>