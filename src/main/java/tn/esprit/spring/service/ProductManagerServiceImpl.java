package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.ProductManager;
import tn.esprit.spring.repositry.ProductManagerRepository;

public class ProductManagerServiceImpl implements IProductManagerService {

	@Autowired
	ProductManagerRepository productManagerRepository;
	
	@Override
	public ProductManager addProductManager(ProductManager pm) {
		
		return productManagerRepository.save(pm);
	}

	@Override
	public ProductManager updateProductManager(ProductManager pm) {
		
		return productManagerRepository.save(pm);
	}

	@Override
	public void deleteProductManager(int id) {
		productManagerRepository.deleteById(id);		
	}

	@Override
	public void retrieveProductManager(int id) {
		productManagerRepository.findById(id);
		
	}

	@Override
	public List<ProductManager> retrieveAllProductManager() {
		List<ProductManager> productManagers =(List<ProductManager>) productManagerRepository.findAll();
		return productManagers;
	}


	public List<ProductManager> retrieveByEmail(String email) {
		List<ProductManager> productManagers = productManagerRepository.findByEmail(email);
		return productManagers;
	}

	@Override
	public List<ProductManager> retrieveByUserName(String name) {
		List<ProductManager> productManagers = productManagerRepository.findByUserName(name);
		return productManagers;
		
	}

	

}
