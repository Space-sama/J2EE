<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<link  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
 <div class="card-header">
 Confirmation L'Ajout des Produits
 </div>
 <div class="card-body">

 <div  class="form-group">
 <label class="control-label">ID :</label>
 <input type="text" name="id" class="form-control" value="${prod.product_id}" disabled="disabled"/>

 <label class="control-label">Nom Produit :</label>
 <input type="text" name="nom" class="form-control" value="${prod.product_name}" disabled="disabled"/>
 </div>

 <div class="control-label">
 <label class="control-label">Prix :</label>
 <input type="text" name="prix" class="form-control" value="${prod.product_price}" disabled="disabled"/>
 </div>
 </div>

 </div>
</div>
</body>
</html>