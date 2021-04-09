package tn.esprit.spring.controler;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.entities.Admin;
import tn.esprit.spring.exception.BadRequestException;
import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.payload.ApiResponse;
import tn.esprit.spring.payload.JwtAuthenticationResponse;
import tn.esprit.spring.payload.LoginRequest;
import tn.esprit.spring.service.AdminServiceImpl;
import tn.esprit.spring.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService ;
	@Autowired
	private UserServiceImpl userService ;
	
	private static final Logger Log = LogManager.getLogger(AdminController.class);
	
	
	//GET Requests

		@GetMapping(value = "/admins/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> findAdmin(@PathVariable("username") String username) {
			Log.info("retrieving admin {}", username);

			return  adminService
					.retrieveByUserName(username)
					.map(admin -> ResponseEntity.ok(admin))
					.orElseThrow(() -> new ResourceNotFoundException(username));
		}

		@GetMapping("/admins/{id}")
		public ResponseEntity<?> one(@PathVariable int id) {

			Log.info("retrieving admin with id {}", id);
			return adminService
					.retrieveAdmin(id)
					.map(admin -> ResponseEntity.ok(admin))
					.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));

		}


		@GetMapping(value = "/admins", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> findAllAdmins() {
			Log.info("retrieving all admins");

			return ResponseEntity
					.ok(adminService.retrieveAllAdmins());
		}
		
		@GetMapping(value = "/admins/users", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> findAllUsers() {
			Log.info("retrieving all Users");

			return ResponseEntity
					.ok(userService.retrieveAllUsers());
		}
		
		//POST Requests

		@PostMapping("/admins")
		public ResponseEntity<ApiResponse> createAdmin(@RequestBody Admin admin) {
			Log.info("updating admin {}",admin.getUser_Name());
			try {
				adminService.registerAdmin(admin);
			} catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
				throw new BadRequestException(e.getMessage());
			}
			URI location = ServletUriComponentsBuilder
					.fromCurrentContextPath().path("/admins/{username}")
					.buildAndExpand(admin.getUser_Name()).toUri();

			return ResponseEntity
					.created(location)
					.body(new ApiResponse(true,"admin registered successfully"));
		}


		@PostMapping("/signin")
		public ResponseEntity<?> authenticateAdmin(@Valid @RequestBody LoginRequest loginRequest) {
			String token = adminService.loginAdmin(loginRequest.getUsername(), loginRequest.getPassword());
			return ResponseEntity.ok(new JwtAuthenticationResponse(token));
		}
		
		//PUT Requests

		@PutMapping("/admins/{id}")
		public ResponseEntity<Admin> update(@PathVariable("id") int id, @RequestBody Admin admin) throws ResourceNotFoundException {

			Log.info("updatinging admin {}",admin.getUser_Name());
			Optional<Admin> adminData = adminService.retrieveAdmin(id);

			if (adminData.isPresent()) {
				return new ResponseEntity<>(adminService.updateAdmin(admin, id), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}


		//DELETE Requests

		@DeleteMapping("/admins/{id}")
		@PreAuthorize("hasRole('Admin')")
		public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") int id) {
			try {
				adminService.deleteAdmin(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}


}
