package projet.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import projet.pi.entity.Ray;

@Repository
public interface RayRepository extends JpaRepository<Ray, Long>{

	//List<Product> findAllProductByrayon(Long id);
	//Ray findBy(Long RayId) ;
	//Ray findBy(String RayDescription) ;
	
	@Query("select r from Ray r where r.RayName=:rayName")
	Ray findByName(@Param("rayName") String RayName);
	

	@Query(value="select ray_name from sections where sections.ray_id =(select ray_id from category where category.categoryname=:categoryname) ",nativeQuery=true)
	List<String> findByCategory(@Param("categoryname") String categories);
	List<Ray> findAll() ;
	@Query(value="select sum(quantity) from products where category_id in (select category_id from category where ray_id =:id) ",nativeQuery=true)
	int UpdateSumCapacityRayon(@Param("id") Ray ray);
	
	
}
