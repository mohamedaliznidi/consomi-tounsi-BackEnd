package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.DeliveryMan;

public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Integer> {

}
