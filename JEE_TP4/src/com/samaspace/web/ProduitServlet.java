package com.samaspace.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samaspace.dao.IProduitDAO;
import com.samaspace.dao.ProduitDAO_Impl;
import com.samaspace.metier.Produit;

@WebServlet (name="cs", urlPatterns= {"/Controller","*.io"})
public class ProduitServlet extends HttpServlet {

	
	IProduitDAO metier;
	
	@Override
	public void init() throws ServletException {
		
		metier = new ProduitDAO_Impl();
	}
	
	@SuppressWarnings("static-access")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
			if(path.equals("/index.io")) {
				
				request.getRequestDispatcher("Produits.jsp").forward(request, response);
			}
			
			else if (path.equals("/chercher.io")) {
				
				String key = request.getParameter("key");
				ProduitModele Pm = new ProduitModele();
				Pm.setKey(key);
				List<Produit> Prods = metier.findProducts(key);
				Pm.setProduits(Prods);
				request.setAttribute("model", Pm);
				request.getRequestDispatcher("Produits.jsp").forward(request, response);
			}
			
			else if (path.equals("/saisie.io")) {
				
				request.getRequestDispatcher("/saisieProduit.jsp").forward(request, response);
			}
			
			else if (path.equals("/insert.io") && request.getMethod().equals("POST")) {
				
				String nom = request.getParameter("name");
				double prix = Double.parseDouble(request.getParameter("prix"));
					Produit Pr = metier.saveProduct(new Produit(nom, prix));
					request.setAttribute("prod", Pr);
					request.getRequestDispatcher("/confirmation.jsp").forward(request, response);

			}
			
			else if (path.equals("/supprimer.io")) {
					
				Long id = Long.parseLong(request.getParameter("id"));
				metier.delteProducts(id);
				response.sendRedirect("chercher.io?key=");
			}
			
			else if (path.equals("/editer.io")) {
				
				int id = Integer.parseInt(request.getParameter("id"));
				Produit Pr = metier.getNumProducts(id);
				request.setAttribute("getNumProduit", Pr);
				request.getRequestDispatcher("/editer.jsp").forward(request, response);
			}
			
			else if (path.equals("/update.io")) {
				
					int id = Integer.parseInt(request.getParameter("id"));
					String nom = request.getParameter("nom");
					Double prix = Double.parseDouble(request.getParameter("prix"));
					
					Produit Prod = new Produit();
					Prod.setProduct_id(id);
					Prod.setProduct_name(nom);
					Prod.setProduct_price(prix);
					
					metier.updateProduct(Prod);
					
					request.setAttribute("prod", Prod);
					request.getRequestDispatcher("/confirmation.jsp").forward(request, response);
			}
			
			else {
				
				response.sendError(response.SC_NOT_FOUND);
				
			}
			
			
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
	 HttpServletResponse res) throws
	ServletException, IOException {
	doGet(req,res);
	}

}
