package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Product1;
import tn.esprit.spring.repositry.productRepository1;


@Service
public class productServiceImpl1 {
	
	@Autowired
	productRepository1 product_rep;
 
	
//algo promotion	
	public String Promotion () {
		 List<Product1> Products = product_rep.findAll();
		 
		 for (int i = 0; i < Products.size(); i++) {
			 
			 long diffInMsecondes = new java.util.Date().getTime()-Products.get(i).getUpdatedAt().getTime();
			 long diffJour = diffInMsecondes / (1000 *60 *60 *24) ; 
			    
			    	if(diffJour>30 && Products.get(i).getSold() <10)
			    	{ Products.get(i).setRemisePrice(20.0);
			    	product_rep.save(Products.get(i));
			 return "Et voila notre nouveau promo du mois :  !" 
			    			+Products.get(i).getProductName() + "avec 20% de remise ! soyez nombreux !!" ;}
			
		 }
		return "this is not working !";
		 
	}}
