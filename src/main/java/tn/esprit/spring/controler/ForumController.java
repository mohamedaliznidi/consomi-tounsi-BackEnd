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
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.service.CommentForumServiceImpl;
import tn.esprit.spring.service.SubjectServiceImpl;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class ForumController {

	@Autowired SubjectServiceImpl subjectService;
	@Autowired CommentForumServiceImpl commentForumService;
	
	@GetMapping("/users/subjects")
	List<Subject> allSubjects() {
		return subjectService.retrieveAllSubject();
	}

	@GetMapping("/users/subjects/{id}")
	public ResponseEntity<Subject> oneSubject(@PathVariable int id) {

		Optional<Subject> subjectData = subjectService.retrieveSubject(id);
		if (subjectData.isPresent()) {
			return new ResponseEntity<Subject>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/users/comments")
	List<CommentForum> allComments() {
		return commentForumService.retrieveAllCommentForum();
	}

	@GetMapping("/users/comments/{id}")
	public ResponseEntity<CommentForum> one(@PathVariable int id) {

		Optional<CommentForum> commentData = commentForumService.retrieveCommentForum(id);
		if (commentData.isPresent()) {
			return new ResponseEntity<CommentForum>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	
	
	//POST Requests

		@PostMapping("/managers/subjects")
		public ResponseEntity<Subject> createUser(@RequestBody Subject s) {
			try {
				subjectService.addSubject(s);
				return new ResponseEntity<>( HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping("/clients/comments")
		public ResponseEntity<CommentForum> createComment(@RequestBody CommentForum cf ) {
			try {
				commentForumService.addCommentForum(cf);
				return new ResponseEntity<>( HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//PUT Requests

		@PutMapping("/managers/subjects/{id}")
		public ResponseEntity<Subject> update(@PathVariable("id") int id, @RequestBody Subject s) {
			Optional<Subject> subjectData = subjectService.retrieveSubject(id);

			if (subjectData.isPresent()) {
				return new ResponseEntity<>(subjectService.updateSubject(s,id), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		//DELETE Requests
		
		@DeleteMapping("/admins/subjects/{id}")
		public ResponseEntity<HttpStatus> deleteSubject(@PathVariable("id") int id) {
			try {
				subjectService.deleteSubject(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/clients/comments/{id}")
		public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") int id) {
			try {
				commentForumService.deleteCommentForum(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
