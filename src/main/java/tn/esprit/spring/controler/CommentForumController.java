package tn.esprit.spring.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.CommentForum;
import tn.esprit.spring.service.ICommentForumService;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CommentForumController {
	@Autowired
	ICommentForumService commentForumService;
	
	
	//GET Requests 

	@GetMapping("/user/commentforum")
	List<CommentForum> all() {
		return commentForumService.retrieveAllCommentForum();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<CommentForum> one(@PathVariable int id) {

		Optional<CommentForum> commentData = commentForumService.retrieveCommentForum(id);
		if (commentData.isPresent()) {
			return new ResponseEntity<CommentForum>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	//POST Requests

	@PostMapping("/user")
	public ResponseEntity<CommentForum> createComment(@RequestBody CommentForum cf ) {
		try {
			commentForumService.addCommentForum(cf);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT Requests

	@PutMapping("/user/{id}")
	public ResponseEntity<CommentForum> update(@PathVariable("id") int id, @RequestBody CommentForum cf) {
		Optional<CommentForum> commentData = commentForumService.retrieveCommentForum(id);

		if (commentData.isPresent()) {
			return new ResponseEntity<>(commentForumService.updateCommentForum(cf), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	//DELETE Requests
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") int id) {
		try {
			commentForumService.deleteCommentForum(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}