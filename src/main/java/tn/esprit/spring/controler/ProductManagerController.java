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

import tn.esprit.spring.entities.ProductManager;
import tn.esprit.spring.exception.BadRequestException;
import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.payload.ApiResponse;
import tn.esprit.spring.payload.JwtAuthenticationResponse;
import tn.esprit.spring.payload.LoginRequest;
import tn.esprit.spring.service.ProductManagerServiceImpl;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductManagerController {
	
	@Autowired
	private ProductManagerServiceImpl pmService;
	
	private static final Logger Log = LogManager.getLogger(ProductManagerController.class);

	//GET Requests

		@GetMapping(value = "/managers/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> findManager(@PathVariable("username") String username) {
			Log.info("retrieving manager {}", username);

			return  pmService
					.retrieveByUserName(username)
					.map(client -> ResponseEntity.ok(client))
					.orElseThrow(() -> new ResourceNotFoundException(username));
		}
		
		@GetMapping(value = "/managers", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> findAll() {
			Log.info("retrieving all managers");

			return ResponseEntity
					.ok(pmService.retrieveAllManagers());
		}
		
		@GetMapping(value = "/managers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> one(@PathVariable int id) {

			Log.info("retrieving manager with id {}", id);
			return  pmService
					.retrieveManager(id)
					.map(pm -> ResponseEntity.ok(pm))
					.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));

		}
		
		//POST Requests

		@PostMapping("/managers")
		public ResponseEntity<ApiResponse> createManager(@RequestBody ProductManager pm) {
			Log.info("updating manager {}", pm.getUsername());
			try {
				pmService.registerManager(pm);
			} catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
				throw new BadRequestException(e.getMessage());
			}
			URI location = ServletUriComponentsBuilder
					.fromCurrentContextPath().path("/managers/{username}")
					.buildAndExpand(pm.getUsername()).toUri();

			return ResponseEntity
					.created(location)
					.body(new ApiResponse(true,"User registered successfully"));
		}
		
		 @PostMapping("/signin")
		    public ResponseEntity<?> authenticateClient(@Valid @RequestBody LoginRequest loginRequest) {
		        String token = pmService.loginManager(loginRequest.getUsername(), loginRequest.getPassword());
		        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
		    }
		 
		//PUT Requests

			@PutMapping("/managers/{id}")
			public ResponseEntity<ProductManager> update(@PathVariable("id") int id, @RequestBody ProductManager pm) {

				Log.info("updating manager {}",pm.getUsername());
				Optional<ProductManager> pmData = pmService.retrieveManager(id);

				if (pmData.isPresent()) {
					return new ResponseEntity<>(pmService.updateManager(pm,id), HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			
			//DELETE Requests

			@DeleteMapping("/managers/{id}")
			@PreAuthorize("hasRole('Admin')")
			public ResponseEntity<HttpStatus> deleteManager(@PathVariable("id") int id) {
				try {
					pmService.deleteManager(id);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				} catch (Exception e) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

}
