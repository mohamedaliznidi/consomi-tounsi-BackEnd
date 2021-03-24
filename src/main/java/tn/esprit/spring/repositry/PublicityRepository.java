package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Publicity;

public interface PublicityRepository extends JpaRepository<Publicity, Integer> {
	

}
