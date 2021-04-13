package tn.esprit.spring.repositry;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Basket;


@Repository
public interface BasketRepository extends CrudRepository<Basket, Integer>{

	/*@Query("SELECT bb FROM Basket bb WHERE bb.idClient.id= :idClient")
	List<Basket> findByClient1(@Param("idClient") Long idClient); */

		
	}

