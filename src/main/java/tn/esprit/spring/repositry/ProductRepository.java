package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.PublicityCategory;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	List<Product> findByQuantityLessThan(int quantity);
	//List<Product> findByProductCategory(ProductCategory category);
	
	@Query("SELECT p FROM Product p WHERE p.productCategory= :productCategory")
	List<Product> findByProductCategory(@Param("productCategory") ProductCategory productCategory);
	
	List<Product> findByCategoryname(String name);

}
