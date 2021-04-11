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

import tn.esprit.spring.exception.*;
import tn.esprit.spring.payload.*;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.exception.ResourceNotFoundException;

import tn.esprit.spring.service.ClientServiceImpl;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientServiceImpl clientService;

	private static final Logger Log = LogManager.getLogger(ClientController.class);


	//GET Requests

	@GetMapping(value = "/clients/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findClient(@PathVariable("username") String username) {
		Log.info("retrieving client {}", username);

		return  clientService
				.retrieveByUserName(username)
				.map(client -> ResponseEntity.ok(client))
				.orElseThrow(() -> new ResourceNotFoundException(username));
	}

	@GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {
		Log.info("retrieving all clients");

		return ResponseEntity
				.ok(clientService.retrieveAllClients());
	}

	@GetMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> one(@PathVariable int id) {

		Log.info("retrieving client with id {}", id);
		return  clientService
				.retrieveClient(id)
				.map(client -> ResponseEntity.ok(client))
				.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));

	}

	//POST Requests

	@PostMapping("/clients")
	public ResponseEntity<ApiResponse> createClient(@RequestBody Client client) {
		Log.info("updating client {}",client.getUser_Name());
		try {
			clientService.registerClient(client);
		} catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
			throw new BadRequestException(e.getMessage());
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/clients/{username}")
				.buildAndExpand(client.getUser_Name()).toUri();

		return ResponseEntity
				.created(location)
				.body(new ApiResponse(true,"User registered successfully"));
	}


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateClient(@Valid @RequestBody LoginRequest loginRequest) {
		String token = clientService.loginClient(loginRequest.getUsername(), loginRequest.getPassword());
		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}


	//PUT Requests

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> update(@PathVariable("id") int id, @RequestBody Client client) throws ResourceNotFoundException {

		Log.info("updatinging client {}",client.getUser_Name());
		Optional<Client> clientData = clientService.retrieveClient(id);

		if (clientData.isPresent()) {
			return new ResponseEntity<>(clientService.updateClient(client,id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	//DELETE Requests

	@DeleteMapping("/clients/{id}")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") int id) {
		try {
			clientService.deleteClient(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
