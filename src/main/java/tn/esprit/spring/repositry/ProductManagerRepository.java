package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.ProductManager;

@Repository
public interface ProductManagerRepository extends JpaRepository<ProductManager, Integer> {

	List<ProductManager> findByUserName(String user_name);

	List<ProductManager> findByEmail(String email);

}
