package tn.esprit.spring.repositry;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByUserName(String user_name);

	Optional<Admin> findByEmail(String email);

	Optional<Admin> findByFullName(String first_name, String last_name);

}
