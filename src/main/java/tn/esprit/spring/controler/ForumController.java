package tn.esprit.spring.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.CommentForum;
import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.exception.ResourceNotFoundException;
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

	@RequestMapping( value = "/users/subjects" ,params = "id" , method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> oneSubject(@RequestParam int id ) {

		return subjectService
				.retrieveSubject(id)
				.map(subject ->ResponseEntity.ok(subject))
				.orElseThrow(()-> new ResourceNotFoundException(String.valueOf(id)));

	}

	@GetMapping("/users/comments")
	List<CommentForum> allComments() {
		return commentForumService.retrieveAllCommentForum();
	}

	@RequestMapping( value = "/users/comments" , params = "id" , method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CommentForum> one(@RequestParam int id) {

		Optional<CommentForum> commentData = commentForumService.retrieveCommentForum(id);
		if (commentData.isPresent()) {
			return new ResponseEntity<CommentForum>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}



	//POST Requests

	@PostMapping("/managers/subjects")
	public ResponseEntity<Subject> createSubject(@RequestBody Subject s) {

		try {
			subjectService.addSubject(s);

			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(s, HttpStatus.INTERNAL_SERVER_ERROR);
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

	@RequestMapping(value = "/managers/subjects",params = "id", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Subject> update(@RequestParam int id, @RequestBody Subject s) {
		Optional<Subject> subjectData = subjectService.retrieveSubject(id);

		if (subjectData.isPresent()) {
			return new ResponseEntity<>(subjectService.updateSubject(s,id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//DELETE Requests



	@RequestMapping(value = "/admins/subjects", params = "id",method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteSubject(@RequestParam int id) {
		try {
			subjectService.deleteSubject(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/clients/comments", params = "id",method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteComment(@RequestParam int id) {
		try {
			commentForumService.deleteCommentForum(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
