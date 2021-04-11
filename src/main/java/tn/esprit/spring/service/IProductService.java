package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;

public interface IProductService {
	Product addProduct(Product p);//ok
	void deleteProduct(int id);//ok
	Product retrieveProduct(int id);//ok
	Product updateProduct(Product p);//ok
	List<Product> retrieveAllProducts();//ok
	List<Product> retrieveByName(String name);//ok
	List<Product> retrieveQuantityLessThan(int quantity);//ok
	List<Product> retrieveByProductCategory(ProductCategory productCategory);//reste
	public List<Product> retrieveByProductCategoryName(String name);
	
	

}
