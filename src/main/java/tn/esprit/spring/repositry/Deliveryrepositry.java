package tn.esprit.spring.repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Delivery;



@Repository

public interface Deliveryrepositry extends JpaRepository<Delivery,Long > {
	@Query("SELECT a FROM Delivery a WHERE id_deliv= ?1")
	public Delivery  getDelivById(@Param("id_deliv") Long id_deliv );
	

}
