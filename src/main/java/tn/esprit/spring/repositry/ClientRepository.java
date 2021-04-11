package tn.esprit.spring.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	
	Optional<Client> findByUsername(String user_name);
	Optional<Client> findByEmail(String email);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
