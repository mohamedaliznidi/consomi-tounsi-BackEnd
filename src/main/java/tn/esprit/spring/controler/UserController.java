package tn.esprit.spring.controler;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import tn.esprit.spring.entities.UserStorage;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.payload.JwtAuthenticationResponse;
import tn.esprit.spring.payload.LoginRequest;
import tn.esprit.spring.service.UserServiceImpl;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class UserController {

	
	@Autowired
	private UserServiceImpl userService ;
	
	@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE, params = "username", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findUser(@RequestParam String username) {
		

		return  userService
				.retrieveByUsername(username)
				.map(user -> ResponseEntity.ok(user))
				.orElseThrow(() -> new ResourceNotFoundException(username));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginRequest loginRequest) {
		String token = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}
	
	
	
    @GetMapping("/api/fetchAllUsers")
    public Set<String> fetchAll() {
        return UserStorage.getInstance().getUsers();
    }
    
    
}
