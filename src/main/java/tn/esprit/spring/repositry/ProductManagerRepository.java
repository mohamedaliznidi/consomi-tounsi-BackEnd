package tn.esprit.spring.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.ProductManager;

@Repository
public interface ProductManagerRepository extends JpaRepository<ProductManager, Integer> {
	
	Optional<ProductManager> findByUsername(String user_name);
	Optional<ProductManager> findByEmail(String email);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
