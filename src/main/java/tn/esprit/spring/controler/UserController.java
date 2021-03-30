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

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.IUserService;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	IUserService userService;
	
	
	//GET Requests 

	@GetMapping("/user")
	List<User> all() {
		return userService.retrieveAllUsers();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> one(@PathVariable int id) {

		Optional<User> userData = userService.retrieveUser(id);
		if (userData.isPresent()) {
			return new ResponseEntity<User>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	//POST Requests

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			userService.addUser(user);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT Requests

	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user) {
		Optional<User> userData = userService.retrieveUser(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	//DELETE Requests
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}