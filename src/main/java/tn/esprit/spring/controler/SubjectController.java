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

import tn.esprit.spring.entities.Subject;
import tn.esprit.spring.service.ISubjectService;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class SubjectController {
	@Autowired
	ISubjectService subjectService;
	
	
	//GET Requests 

	@GetMapping("/user/subject")
	List<Subject> all() {
		return subjectService.retrieveAllSubject();
	}

	@GetMapping("/user/subject/{id}")
	public ResponseEntity<Subject> one(@PathVariable int id) {

		Optional<Subject> subjectData = subjectService.retrieveSubject(id);
		if (subjectData.isPresent()) {
			return new ResponseEntity<Subject>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	//POST Requests

	@PostMapping("/manager/subject")
	public ResponseEntity<Subject> createUser(@RequestBody Subject s) {
		try {
			subjectService.addSubject(s);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT Requests

	@PutMapping("/manager/subject/{id}")
	public ResponseEntity<Subject> update(@PathVariable("id") int id, @RequestBody Subject s) {
		Optional<Subject> subjectData = subjectService.retrieveSubject(id);

		if (subjectData.isPresent()) {
			return new ResponseEntity<>(subjectService.updateSubject(s), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	//DELETE Requests
	
	@DeleteMapping("/admin/subject/{id}")
	public ResponseEntity<HttpStatus> deleteSubject(@PathVariable("id") int id) {
		try {
			subjectService.deleteSubject(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}