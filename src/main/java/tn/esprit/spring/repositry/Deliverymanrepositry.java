<<<<<<< HEAD
/*package tn.esprit.spring.repositry;
=======
package tn.esprit.spring.repositry;
>>>>>>> abir

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

<<<<<<< HEAD
import tn.esprit.spring.entities.*;
=======
import tn.esprit.spring.entities.Deliveryman;

>>>>>>> abir


public interface Deliverymanrepositry extends  JpaRepository<Deliveryman, Long> {

	@Query("SELECT a FROM Deliveryman a WHERE lastname= ?1")
	public List<Deliveryman> getDeliveryByDeliveryname(@Param("lastname") String lastname);
	
	@Query("SELECT a FROM Deliveryman a WHERE delivery_id= ?1")
	public Deliveryman  getDeliveryById(@Param("delivery_id") Long delivery_id );
<<<<<<< HEAD
}
*/
=======
	
	@Query("SELECT a FROM Deliveryman a WHERE delivery_id= ?1")
	public Deliveryman  getprime(@Param("delivery_id") Long delivery_id );
}

>>>>>>> abir
