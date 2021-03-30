package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.CommentForum;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.repositry.CommentForumRepository;

public class CommentForumServiceImpl implements ICommentForumService {

	@Autowired
	CommentForumRepository commentForumRepository;
	
	@Override
	public CommentForum addCommentForum(CommentForum cf) {
		return commentForumRepository.save(cf);
	}

	@Override
	public CommentForum updateCommentForum(CommentForum cf) {
	
		return commentForumRepository.save(cf);
	}

	@Override
	public void deleteCommentForum(int id) {
		commentForumRepository.deleteById(id);
		
	}

	@Override
	public Optional<CommentForum> retrieveCommentForum(int id) {
		return commentForumRepository.findById(id);
		
	}

	@Override
	public List<CommentForum> retrieveAllCommentForum() {
		List<CommentForum> commentsForum = (List<CommentForum>) commentForumRepository.findAll();
		return commentsForum;
	}

	@Override
	public Optional<CommentForum> retrieveByDate(Date d) {
		Optional<CommentForum> commentsForum =  commentForumRepository.findByDate(d);
		return commentsForum;
	}

	@Override
	public Optional<CommentForum> retrieveBySubject(Subject s) {
		Optional<CommentForum> commentsForum =commentForumRepository.findBySubject(s);
		return commentsForum;
	}

}
