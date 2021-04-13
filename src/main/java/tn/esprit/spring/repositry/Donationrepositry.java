package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Donation;

@Repository
public interface Donationrepositry extends JpaRepository<Donation,Integer>{

}
