package tn.esprit.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.CommentForum;

public interface CommentForumRepository extends JpaRepository<CommentForum, Integer> {

}
