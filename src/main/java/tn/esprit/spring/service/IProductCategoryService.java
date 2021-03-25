package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.ProductCategory;

public interface IProductCategoryService {
	
	ProductCategory addProductCategory(ProductCategory p);
	void deleteProductCategory(int id);
	void retrieveProductCategory(int id);
	ProductCategory updateProductCategory(ProductCategory p);
	List<ProductCategory> retrieveAllProductCategories();
	List<ProductCategory> retrieveByName(String name);

}
