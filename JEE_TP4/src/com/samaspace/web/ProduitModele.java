package com.samaspace.web;

import java.util.ArrayList;
import java.util.List;

import com.samaspace.metier.Produit;

public class ProduitModele {
	
	private String key;
	List<Produit> produits = new ArrayList<>();
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	

}

