package tn.esprit.spring.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Optional<Admin> findByUserName(String user_name);
	Optional<Admin> findByEmail(String email);
	Optional<Admin> findByFullName(String first_name, String last_name);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
