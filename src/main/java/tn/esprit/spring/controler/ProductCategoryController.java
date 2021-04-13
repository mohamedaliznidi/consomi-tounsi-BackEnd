package tn.esprit.spring.controler;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.service.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//reste modify


@RestController
@CrossOrigin("*")
@RequestMapping("productcategory")

public class ProductCategoryController {
	
	@Autowired
	IProductCategoryService productcategoryservice;
	
	@PostMapping ("/addproductcategory")
	public void add(@RequestBody ProductCategory p){
		this.productcategoryservice.addProductCategory(p);
		
		
	}
	@DeleteMapping("/removeproductcategory/{id}")
	@ResponseBody
	public void removeProductCategory(@PathVariable("id") int id) {
	productcategoryservice.deleteProductCategory(id);
	}
	
	@GetMapping("/findproductcategory/{id}")
	@ResponseBody
	public ProductCategory findproductcategory(@PathVariable("id") int id){
		ProductCategory productcategoryresponse =  (ProductCategory) productcategoryservice.retrieveProductCategory(id);
		return productcategoryresponse;
		
		}
	
	@GetMapping("/productcategories")
	public Iterable<ProductCategory> getAll(){
		return this.productcategoryservice.retrieveAllProductCategories();
	}
	@GetMapping("/findproductbycategory/{categoryName}")
	@ResponseBody
	public List<ProductCategory> findproductcategory(@PathVariable("categoryName") String categoryName){
		List<ProductCategory> productcategoryresponse =  (List<ProductCategory>) productcategoryservice.retrieveByName(categoryName);
		return productcategoryresponse;
		
		}
	
	
	@PutMapping("/modifyproductcategory")
	@ResponseBody
	public void modifyProductCategory(@RequestBody ProductCategory p) {
	 productcategoryservice.updateProductCategory(p);
	}
	
}

