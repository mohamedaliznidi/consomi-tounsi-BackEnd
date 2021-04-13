package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Product1;

@Repository
public interface productRepository1 extends JpaRepository<Product1, Long> {
	@Query(value="SELECT * FROM products p where p.category_id =(select c.category_id from category c where c.ray_id=:id)",nativeQuery=true)
	List<Product1> findAllProductByrayon(@Param("id")Long id) ;
	//List<Long> findAll(Integer sold) ;
	@Query(value="select max(sold) from products where category_id in (select category_id from category where ray_id =:ray_id)",nativeQuery=true)
	int findBestProductByrayId(@Param("ray_id") Long id); 
	@Query(value="select ray_id from sections",nativeQuery=true)
	List<Integer> findRayon_id();
	@Query(value="select * from products where products.sold = :sold",nativeQuery=true)
	Product1 findBestProduct(@Param("sold") int sold);
	
	/*@Query(value="update sections set best_product where ")
	void UpdateBestProduct();*/


}
