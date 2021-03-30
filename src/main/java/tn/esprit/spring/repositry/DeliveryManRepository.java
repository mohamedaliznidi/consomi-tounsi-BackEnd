package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.DeliveryMan;

@Repository
public interface DeliveryManRepository extends  JpaRepository<DeliveryMan, Integer> {

	List<DeliveryMan> findByUserName(String user_name);

}
