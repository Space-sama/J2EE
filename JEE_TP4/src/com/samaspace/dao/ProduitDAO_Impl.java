package com.samaspace.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.samaspace.metier.DbInteraction;
import com.samaspace.metier.Produit;

public class ProduitDAO_Impl implements IProduitDAO {

	
	public Produit saveProduct(Produit P){
		
		
		try {
			
			DbInteraction.Connecter();
			PreparedStatement PS = DbInteraction.conn.prepareStatement("INSERT INTO products(Product_Name, Product_Price) VALUES(?,?)");
			

			PS.setString(1, P.getProduct_name());
			PS.setDouble(2, P.getProduct_price());
			PS.executeUpdate();
			
			PreparedStatement PS1 = DbInteraction.conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM products");
			
			ResultSet RS = PS1.executeQuery();
			
			if (RS.next()) {
				
				P.setProduct_id(RS.getInt("MAX_ID"));
				//System.out.println("ID OF THE PRODUCT " + " " + RS.getLong("MAX"));
			}
			PS.close();
			PS1.close();
			
			
			
		} catch (Exception e) {
			System.out.println("NOT ADDED !");
			e.printStackTrace();
		}
		return P;
		
	}

	@Override
	public List<Produit>  findProducts(String Pr) {
		System.out.println("********** SEARCHIING ... ***********");
		List<Produit> Prods = new ArrayList<>();
		
		try {
			
			DbInteraction.Connecter();
			PreparedStatement PS = DbInteraction.conn.prepareStatement("SELECT * FROM Products WHERE Product_Name LIKE ?");
			PS.setString(1, "%"+Pr+"%");
			ResultSet RS = PS.executeQuery();
			
			while (RS.next()) {
				
				Produit P = new Produit();
				P.setProduct_id(RS.getInt("id"));
				P.setProduct_name(RS.getString("Product_Name"));
				P.setProduct_price(RS.getDouble("Product_Price"));
				Prods.add(P);
				
			}
			PS.close();
			
			
			
		} catch (Exception e) {
			System.out.println("CANNOT FIND THE PRODUCT");
		}
		
		return Prods;
	}

	
	@Override
	public Produit getNumProducts(int id) {

		Produit P = new Produit();
		try {
			
			DbInteraction.Connecter();
			
			PreparedStatement PS = DbInteraction.conn.prepareStatement("SELECT *FROM products WHERE id = ?");
			PS.setLong(1, id);
			
			ResultSet RS = PS.executeQuery();
			
			while (RS.next()) {
				
				P.setProduct_id(RS.getInt("id"));
				P.setProduct_name(RS.getString("Product_Name"));
				P.setProduct_price(RS.getDouble("Product_Price"));
				
				
			}
			
		} catch (Exception e) {
			
			System.out.println("CANNOT GET THE ID !");
		}
		return P;
	
		
	}

	@Override
	public Produit updateProduct(Produit P) {
		
		Produit Produit = new Produit();
		try {
			
			DbInteraction.Connecter();
			System.out.println("******** UPDATE *********");
			PreparedStatement PS = DbInteraction.conn.prepareStatement("UPDATE Products SET Product_Name=?, Product_Price=? WHERE "
					+ "id =?");
			
			PS.setString(1, P.getProduct_name());
			PS.setDouble(2, P.getProduct_price());
			PS.setInt(3, P.getProduct_id());
			PS.executeUpdate();
			PS.close();
			
			
		} catch (Exception e) {
			
			System.out.println("CANNOT UPDATED !");
		}
		return Produit;
	}

	@Override
	public Produit delteProducts(Long id) {
		
		Produit Produit = new Produit();
		try {
			
			DbInteraction.Connecter();
			PreparedStatement PS = DbInteraction.conn.prepareStatement("DELETE FROM Products WHERE id=?");
			PS.setLong(1, id);
			int rs = PS.executeUpdate();
			PS.close();
			if(rs == 1) {
				System.out.println("Product " + id + " deleted !");
				
			}
			else {
				System.out.println("WE CANNOT FIND THIS ID !");
			}
			
		} catch (Exception e) {
			
			System.out.println("Product NOT deleted !");
		}
		return Produit;
	}

	
}
