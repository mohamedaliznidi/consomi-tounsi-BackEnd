package tn.esprit.spring.repositry;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	List<ProductCategory> findByCategoryName(String name);

}
