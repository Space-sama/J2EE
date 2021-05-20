<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="ISO-8859-1">
<title>Bienvenue</title>

<link  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">
			
				<b>Chercher un produit(s)</b><br />
			
			</div>
			
			<div class="card-body">
				<form action="chercher.io" method="get">
					<input type="text" name="key" value="${model.key}" /><br /><br />
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form><br />
				
				<table class="table table-striped">
				
					<tr>
						<th>ID</th> <th>Name</th> <th>Price</th>
					</tr>
					
					<c:forEach var="p" items="${model.produits}">
					<tr>
						<td>${p.product_id}</td>
						<td>${p.product_name}</td>
						<td>${p.product_price}</td>
						<td><a onclick="return confirm('Vous voulez vraiment supprimer çe produit ?')"
						href="/JEE_TP4/supprimer.io?id=${p.product_id}">Supprimer</a></td>
						<td> <a href="/JEE_TP4/editer.io?id=${p.product_id}">Editer le produit</a></td>
					</tr>
					</c:forEach>
				
				</table>
			
			</div>
		
		</div>
	
	</div>
</body>
</html>