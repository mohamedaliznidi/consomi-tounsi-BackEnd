package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.repositry.*;
import tn.esprit.spring.service.*;
import tn.esprit.spring.entities.*;


@RestController
@RequestMapping("/product")
public class ProductController1 {
	
	@Autowired
	productServiceImpl1 prod_service;
	@Autowired
	tn.esprit.spring.service.RayServiceImpl ray_service;
	@Autowired
	tn.esprit.spring.repositry.RayRepository rayRepository;
	@Autowired
	productRepository1 product_rep;
	@Autowired
	BestOf Best ;
	
	
	@PutMapping("/getbestproductbyrayon")
	public List<Product1> getbestproductbyrayon(){
		return ray_service.updateRayon();
	}
	@PutMapping("/Promotion")
	public String Promotion () {
		return prod_service.Promotion();
		
	}
	

}