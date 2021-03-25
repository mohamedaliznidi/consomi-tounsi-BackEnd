package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.ProductManager;

public interface ProductManagerRepository extends JpaRepository<ProductManager, Integer> {

}
