package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;

public interface IProductService {
	Product addProduct(Product p);
	void deleteProduct(int id);
	void retrieveProduct(int id);
	Product updateProduct(Product p);
	List<Product> retrieveAllProducts();
	List<Product> retrieveByName(String name);
	List<Product> retrieveQuantityLessThan(int quantity);
	List<Product> retrieveByProductCategory(ProductCategory productcategory);
	
	

}
