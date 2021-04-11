package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.ProductCategory;

public interface IProductCategoryService {
	
	ProductCategory addProductCategory(ProductCategory p);
	void deleteProductCategory(int id);
	ProductCategory retrieveProductCategory(int id);
	ProductCategory updateProductCategory(ProductCategory p);
	List<ProductCategory> retrieveAllProductCategories();
	List<ProductCategory> retrieveByName(String name);

}
