package projet.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projet.pi.entity.Product;

@Repository
public interface productRepository extends JpaRepository<Product, Long> {
	@Query(value="SELECT * FROM products p where p.category_id =(select c.category_id from category c where c.ray_id=:id)",nativeQuery=true)
	List<Product> findAllProductByrayon(@Param("id")Long id) ;
	//List<Long> findAll(Integer sold) ;
	@Query(value="select max(sold) from products where category_id in (select category_id from category where ray_id =:ray_id)",nativeQuery=true)
	Integer findBestProductByrayId(@Param("ray_id") Long id); 
	@Query(value="select ray_id from sections",nativeQuery=true)
	List<Long> findRayon_id();
	@Query(value="select * from products where products.sold = :sold",nativeQuery=true)
	Product findBestProduct(@Param("sold") Integer sold);
	
	/*@Query(value="update sections set best_product where ")
	void UpdateBestProduct();*/


}
