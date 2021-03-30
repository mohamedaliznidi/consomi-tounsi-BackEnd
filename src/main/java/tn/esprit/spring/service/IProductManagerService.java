package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.ProductManager;

public interface IProductManagerService {
	ProductManager addProductManager(ProductManager pm);
	ProductManager updateProductManager(ProductManager pm);
	void deleteProductManager(int id);
	void retrieveProductManager(int id);
	List<ProductManager> retrieveAllProductManager();
	List<ProductManager> retrieveByUserName(String name);
	List<ProductManager> retrieveByEmail(String email);
}
