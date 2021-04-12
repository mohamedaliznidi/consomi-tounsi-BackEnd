package tn.esprit.spring.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Optional<Admin> findByUsername(String user_name);
	Optional<Admin> findByEmail(String email);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
