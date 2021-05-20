<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier le produit</title>
<link  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification des Produits
</div>
<div class="card-body">
<form action="update.io" method="post">
<div hidden class="form-group">
<label class="control-label">ID Produit :</label>
<input type="text" name="id" class="form-control"
value="${getNumProduit.product_id}"/>
</div>
<div class="form-group">
<label class="control-label">Nom Produit :</label>
<input type="text" name="nom" class="form-control"
value="${getNumProduit.product_name}"/>
</div>
<div class="form-group">
<label class="control-label">Prix :</label>
<input type="text" name="prix" class="form-control" value="${getNumProduit.product_price}"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
</div>
</div>


</body>
</html>