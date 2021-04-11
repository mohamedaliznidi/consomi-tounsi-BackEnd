package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.CommentForum;
import tn.esprit.spring.entities.Subject;

public interface ICommentForumService {
	
	CommentForum addCommentForum(CommentForum cf);
	void deleteCommentForum(int id);
	Optional<CommentForum>  retrieveCommentForum(int id);
	List<CommentForum> retrieveAllCommentForum();
	Optional<CommentForum> retrieveByDate(Date d);
	Optional<CommentForum> retrieveBySubject(Subject s);

}
