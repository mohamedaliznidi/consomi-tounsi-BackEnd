package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

}
