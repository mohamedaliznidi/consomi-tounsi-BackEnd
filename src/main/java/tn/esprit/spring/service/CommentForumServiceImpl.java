package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.CommentForum;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.repositry.CommentForumRepository;

@Service
public class CommentForumServiceImpl implements ICommentForumService {

	@Autowired
	CommentForumRepository commentForumRepository;
	
	private static final Logger Log = LogManager.getLogger(CommentForumServiceImpl.class);
	
	@Override
	public CommentForum addCommentForum(CommentForum cf) {
		Log.info("adding comment  {}",cf.getId());
		if(commentForumRepository.existsById(cf.getId())) {
			Log.warn("comment {} already exists.",cf.getId());
			throw new UsernameAlreadyExistsException(
					String.format("comment %s already exists", cf.getId()));
		}
		return commentForumRepository.save(cf);
	}


	@Override
	public void deleteCommentForum(int id) {
		Log.info("deleting comment by id {}", id);
		commentForumRepository.deleteById(id);
		
	}

	@Override
	public Optional<CommentForum> retrieveCommentForum(int id) {
		Log.info("retrieving comment by id {}", id);
		return commentForumRepository.findById(id);
		
	}

	@Override
	public List<CommentForum> retrieveAllCommentForum() {
		Log.info("retriving all comments");
		List<CommentForum> commentsForum = (List<CommentForum>) commentForumRepository.findAll();
		return commentsForum;
	}


	@Override
	public Optional<CommentForum> retrieveBySubject(Subject s) {
		Optional<CommentForum> commentsForum =commentForumRepository.findBySubject(s);
		return commentsForum;
	}

}
