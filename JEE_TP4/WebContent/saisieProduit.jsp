<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter les produits</title>
<link  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

<%@include file="header.jsp" %>
<p></p>

<div class="container">

	<div class="card">
	
		<div class="card-header">
			<b>Ajouter des produits</b>
		</div>
		
		<div class="card-body">
		
			<form action="insert.io" method="post">
			
				<div class="form-group">
					<label class="control-label">Nom du produit: </label>
					<input type="text" class="form-control" name="name" required="required" />
				</div>
				
				<div class="form-group">
					<label class="control-label">Prix du produit: </label>
					<input type="text" class="form-control" name="prix" required="required" />
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Ajouter le produit</button>
				</div>
			
			</form>
		</div>
	
	</div>

</div>

</body>
</html>