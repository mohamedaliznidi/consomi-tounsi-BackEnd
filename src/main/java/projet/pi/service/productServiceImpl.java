package projet.pi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.pi.entity.Product;
import projet.pi.repository.productRepository;


@Service
public class productServiceImpl {
	
	@Autowired
	productRepository product_rep;
 
	
//algo promotion	
	public String Promotion () {
		 List<Product> Products = product_rep.findAll();
		 
		 for (int i = 0; i < Products.size(); i++) {
			 
			 long diffInMsecondes = new java.util.Date().getTime()-Products.get(i).getUpdatedAt().getTime();
			 long diffJour = diffInMsecondes / (1000 *60 *60 *24) ; 
			    
			    	if(diffJour>30 && Products.get(i).getSold() <10)
			    	{ Products.get(i).setRemisePrice(20.0);
			    	product_rep.save(Products.get(i));
			 return "Et voila notre nouveau promo du mois : " 
			    			+Products.get(i).getProductName() + " avec 20% de remise ! soyez nombreux !!" ;}
			
		 }
		return "this is not working !";
		 
	}}
