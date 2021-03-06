package tn.esprit.spring.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	Boolean existsByNamesubject(String subject_name); 
	Optional<Subject> findByNamesubject(String name);

}
