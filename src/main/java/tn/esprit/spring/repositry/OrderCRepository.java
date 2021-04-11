package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.OrderC;

public interface OrderCRepository extends JpaRepository <OrderC, Integer> {

}
