package tn.esprit.spring.controler;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.service.IUserService;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	IUserService userService;
	
	private static final Logger Log = LogManager.getLogger(UserController.class);
	
	//GET Requests 

	@GetMapping("/users")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	List<User> all() {
		return userService.retrieveAllUsers();
	}

	@GetMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	public ResponseEntity<?> one(@PathVariable int id) {
		Log.info("retrieving user with id {}", id);
		return userService
				.retrieveUser(id)
				.map(user -> ResponseEntity.ok(user))
				.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
	
	}
	
	@GetMapping(value = "/clients/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
	public ResponseEntity<?> findUser(@PathVariable("username") String username) {
		Log.info("retrieving user {}", username);

		return  userService
				.retrieveByUserName(username)
				.map(user -> ResponseEntity.ok(user))
				.orElseThrow(() -> new ResourceNotFoundException(username));
	}
	
}