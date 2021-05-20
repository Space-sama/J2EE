package com.samaspace.dao;

import java.util.List;

import com.samaspace.metier.Produit;

public interface IProduitDAO {
	
	
	public Produit saveProduct(Produit P);
	
	public List<Produit> findProducts(String Pr);
	
	public Produit updateProduct(Produit P);

	public Produit delteProducts(Long id);

	Produit getNumProducts(int id);
	
	

}
