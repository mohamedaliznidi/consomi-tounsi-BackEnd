package tn.esprit.spring.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUserName(String user_name);
	Optional<User> findByEmail(String email);
	Optional<User> findByFullName(String first_name, String last_name);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
