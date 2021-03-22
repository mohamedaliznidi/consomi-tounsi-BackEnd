package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	List<Product> findByQuantityLessThan(int quantity);
	List<Product> findByProductCategory(ProductCategory productcategory);
}
