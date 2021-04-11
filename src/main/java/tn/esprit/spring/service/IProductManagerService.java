package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.ProductManager;

public interface IProductManagerService {
	
	ProductManager updateManager(ProductManager pm,int id);
	void deleteManager(int id);
	Optional<ProductManager> retrieveManager(int id);
	List<ProductManager> retrieveAllManagers();
	Optional<ProductManager> retrieveByUserName(String user_name);
	Optional<ProductManager> retrieveByEmail(String email);
	ProductManager registerManager(ProductManager pm);
	String loginManager(String username, String password);

}
