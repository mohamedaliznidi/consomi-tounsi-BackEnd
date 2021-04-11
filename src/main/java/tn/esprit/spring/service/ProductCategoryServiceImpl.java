package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.repositry.ProductCategoryRepository;


@Service
public class ProductCategoryServiceImpl implements IProductCategoryService{
	
	@Autowired
	ProductCategoryRepository ProductCategoryRepository;
	
	
	 private static final Logger L = LogManager.getLogger(ProductCategoryServiceImpl.class);
	
	@Override
	public ProductCategory addProductCategory (ProductCategory p){
		return ProductCategoryRepository.save(p);
	}
	
	@Override
	public void deleteProductCategory(int id){
		ProductCategoryRepository.deleteById(id);
		
	}
	
	@Override
	public ProductCategory updateProductCategory(ProductCategory p){
		return ProductCategoryRepository.save(p);
	}
	
	@Override
	public ProductCategory retrieveProductCategory(int id){
		return ProductCategoryRepository.findById(id).get();
		
	}
	
	@Override
	public List<ProductCategory> retrieveAllProductCategories(){
		List<ProductCategory> ProductCategories = (List<ProductCategory>) ProductCategoryRepository.findAll();
		/**for (ProductCategory ProductCategory : ProductCategorys){
			L.info("ProductCategory +++ : " +user);
		}*/

		return ProductCategories;
		
		}
	
	@Override
	public List<ProductCategory> retrieveByName(String name){
		List<ProductCategory> ProductCategories=ProductCategoryRepository.findByCategoryName(name);
		return ProductCategories;
	}

	
}
