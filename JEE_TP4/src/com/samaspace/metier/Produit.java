package com.samaspace.metier;

import java.io.Serializable;

public class Produit implements Serializable{
	
	private int product_id;
	private String product_name;
	private double product_price;
	
	public Produit() {
		super();
	}
	
	
	public Produit(String product_name, double product_price) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
	}
	
	public Produit(int id, String product_name, double product_price) {
		super();
		this.product_id = id;
		this.product_name = product_name;
		this.product_price = product_price;
	}
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}


	/* @Override
	public String toString() {
		return "Produit [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + "]";
	}*/
	
	

}
