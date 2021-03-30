package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	List<Client> findByUserName(String user_name);

}
