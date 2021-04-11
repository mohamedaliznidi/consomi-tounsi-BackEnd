package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.repositry.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	 private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);
	
	@Override
	public Product addProduct (Product p){
		return productRepository.save(p);
	}
	
	@Override
	public void deleteProduct(int id){
		productRepository.deleteById(id);
		
	}
	
	@Override
	public Product updateProduct(Product p){
		return productRepository.save(p);
	}
	
	@Override
	public void retrieveProduct(int id){
		productRepository.findById(id);
		
	}
	
	@Override
	public List<Product> retrieveAllProducts(){
		List<Product> products = (List<Product>) productRepository.findAll();
		for (Product product : products){
			L.info("product +++ : " + product);
		}
		return products;
		
		}
	
	@Override
	public List<Product> retrieveByName(String name){
		List<Product> products=productRepository.findByName(name);
		return products;
		
	}
	@Override
	public List<Product> retrieveQuantityLessThan(int quantity){
		List<Product> products=productRepository.findByQuantityLessThan(quantity);
		return products;
		
	}
	
	@Override
	public List<Product> retrieveByProductCategory(ProductCategory productcategory){
		List<Product> products=productRepository.findByProductCategory(productcategory);
		return products;
	}

}
