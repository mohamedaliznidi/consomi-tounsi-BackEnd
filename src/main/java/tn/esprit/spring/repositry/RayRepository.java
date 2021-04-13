package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Ray;

@Repository
public interface RayRepository extends JpaRepository<Ray, Long>{

	//List<Product> findAllProductByrayon(Long id);
	//Ray findBy(Long RayId) ;
	//Ray findBy(String RayDescription) ;
	
	@Query("select r from Ray r where r.RayName=:rayName")
	Ray findByName(@Param("rayName") String RayName);
	

	@Query("select r from Ray r where categories= :raycategories")
	List<Ray> findByCategory(@Param("raycategories") String categories);
	List<Ray> findAll() ;
	@Query(value="select sum(quantity) from products where category_id in (select category_id from category where ray_id =:id) ",nativeQuery=true)
	int UpdateSumCapacityRayon(@Param("id") Ray ray);
	
}
