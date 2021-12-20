<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
   table, th, td {
     border:1px solid black;
   }
   
</style>
<body>
    
    <h2>Commande</h2>
    
    <table style="width:100%">
      <tr>
        <th>Pizzas</th>
        <th>Prix</th>
      </tr>
      <%@ page import="java.util.List" %>
      <%@ page import="java.util.ArrayList" %>
      <%@ page import= "projetPizza.Commande" %>
      <%@ page import= "projetPizza.Pizza" %>
  
      <% List <Commande> commandes = new ArrayList<>();
		commandes = (List<Commande>) application.getAttribute("commandes");
		ArrayList<Pizza> pizzas;
		Commande com = commandes.get(Integer.parseInt(request.getParameter("id")));
		pizzas = com.getListPizza();
		%>
		<% int prix = 0; %>
			
		
		<% for(Pizza pizza:pizzas){
			prix = prix + pizza.getPrix();%>
      <tr>
     
        <td><%= pizza.getNom() %>
        </td>
        <td><%= pizza.getPrix() %>€</td>
      </tr>
      <% } %>
    </table>
    <strong>Le prix total à payer : <%= prix %>€</strong> <br>
    

</body>

</html>