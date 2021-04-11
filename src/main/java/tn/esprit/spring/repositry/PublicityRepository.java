package tn.esprit.spring.repositry;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import tn.esprit.spring.controler.Param;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.PublicityCategory;


@Repository
public interface PublicityRepository extends JpaRepository<Publicity, Integer> {
	
//	List<Publicity> findByPublicitycategory (PublicityCategory publicitycategory);
	@Query("SELECT p FROM Publicity p WHERE p.publicitycategory= :publicitycategory")
	List<Publicity> findByPublicitycategory(@Param("publicitycategory") PublicityCategory publicitycategory);
	

}
