package tn.esprit.spring.repositry;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CommentForum;
import tn.esprit.spring.entities.Subject;

@Repository
public interface CommentForumRepository extends JpaRepository<CommentForum, Integer> {

	
	
	Optional<CommentForum> findByDate(Date d);

	Optional<CommentForum> findBySubject(Subject s);

}
