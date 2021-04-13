package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.pi.entity.Product;
import projet.pi.repository.RayRepository;
import projet.pi.repository.productRepository;
import projet.pi.service.BestOf;
import projet.pi.service.RayServiceImpl;
import projet.pi.service.productServiceImpl;
import tn.esprit.spring.repositry.productRepository1;
import tn.esprit.spring.service.productServiceImpl1;


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
	
	@GetMapping("/triBySold")
	public List<Product1> SortBySold(){
		return Best.SortBySold();
	}
	@PutMapping("/getbestproductbyrayon")
	public List<Product1> getbestproductbyrayon(){
		return ray_service.updateRayon();
	}
	@PutMapping("/Promotion")
	public String Promotion () {
		return prod_service.Promotion();
		
	}
	

}