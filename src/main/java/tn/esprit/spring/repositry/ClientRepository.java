package tn.esprit.spring.repositry;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {
	
	
	Optional<Client> findByUserName(String user_name);
	Optional<Client> findByEmail(String email);
	Optional<Client> findByFullName(String first_name, String last_name);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	

}
