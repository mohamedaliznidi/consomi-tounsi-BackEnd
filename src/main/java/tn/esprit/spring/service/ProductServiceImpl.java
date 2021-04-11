package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

>>>>>>> jihene

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

<<<<<<< HEAD

=======
import tn.esprit.spring.entities.CommentProduct;
>>>>>>> jihene
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.repositry.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository productRepository;
	
<<<<<<< HEAD
=======
	@Autowired
	ICommentProductService commentproductservice;
	
>>>>>>> jihene
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
	public Product retrieveProduct(int id){
		return productRepository.findById(id).get();
		
		
	}
	
	@Override
	public List<Product> retrieveAllProducts(){
		List<Product> products = (List<Product>) productRepository.findAll();
		for (Product product : products){
<<<<<<< HEAD
			L.info("product +++ : " + product);
=======
			L.info("product +++ : " +product);
>>>>>>> jihene
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
	public List<Product> retrieveByProductCategory(ProductCategory productCategory){
		List<Product> products=productRepository.findByProductCategory(productCategory);
		return products;
	}
	
	@Override
	public List<Product> retrieveByProductCategoryName(String name){
		List<Product> products=productRepository.findByCategoryname(name);
		return products;
	}
	
	@Scheduled(fixedRate = 10000) 
	public void invokeScheduled() {
		//Date Today=new java.util.Date();  
		List<Product> products =  (List<Product>) productRepository.findAll();
		float sum=0 ;
		for (Product p2 : products){
			//List <CommentProduct > comments = (List<CommentProduct>) p2.getComments();
			int id = p2.getId();
			List <CommentProduct > comments = (List<CommentProduct>) commentproductservice.RetrieveByProduct(id);
			
			if (comments.size() != 0){
				for (CommentProduct c : comments){
					sum = sum+ c.getRate();
				}
				
				
				float generalrate = (float) sum/comments.size();
				p2.setGeneralrate(generalrate);
				productRepository.save(p2);

			}
			
			
		
			
			

		}

	}
	

}
