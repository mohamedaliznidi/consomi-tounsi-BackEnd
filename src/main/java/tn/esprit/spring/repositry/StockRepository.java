package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Stock;



@Repository
public interface StockRepository extends CrudRepository <Stock, Integer> {
	@Query(value="SELECT p.product_id from products p join stock s  on p.stock_id = s.id  where   s.amount<10 ",nativeQuery=true)
	List<Long> missingProduct();
	

}
