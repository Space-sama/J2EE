package TestApp;

import java.util.ArrayList;
import java.util.List;

import com.samaspace.dao.IProduitDAO;
import com.samaspace.dao.ProduitDAO_Impl;
import com.samaspace.metier.DbInteraction;
import com.samaspace.metier.Produit;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		
		ProduitDAO_Impl ProduitDAO = new ProduitDAO_Impl();
		//Produit P = new Produit("iphone5S", 70);
		//ProduitDAO.saveProduct(P);
		
		
		Produit P2 = new Produit(35, "hkander", 300);
		ProduitDAO.delteProducts((long) 36);
		
		ProduitDAO.updateProduct(P2);
		
		
		// SERACH 
		
	 List<Produit> Prods = ProduitDAO.findProducts("A");
	 
	 for (Produit p: Prods) {
		 
		 System.out.println(p.getProduct_name());
	 }
	 
	 
	 
	 
	 
		
		

	}

}
