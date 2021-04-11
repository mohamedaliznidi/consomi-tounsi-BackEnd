package tn.esprit.spring.repositry;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {

}
