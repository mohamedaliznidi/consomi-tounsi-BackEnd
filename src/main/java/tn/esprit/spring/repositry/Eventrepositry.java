package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Event;

@Repository
public interface Eventrepositry extends JpaRepository<Event,Integer> {

}