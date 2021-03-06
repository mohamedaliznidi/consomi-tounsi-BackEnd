package tn.esprit.spring.controler;

import java.net.URI;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value ="/clients", produces = MediaType.APPLICATION_JSON_VALUE, params = "username", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findClient(@RequestParam String username) {
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

	@RequestMapping(value ="/clients", produces = MediaType.APPLICATION_JSON_VALUE, params = "id", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> one(@RequestParam int id) {

		Log.info("retrieving client with id {}", id);
		return  clientService
				.retrieveClient(id)
				.map(client -> ResponseEntity.ok(client))
				.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));

	}

	//POST Requests

	@PostMapping("/clients")
	public ResponseEntity<ApiResponse> createClient(@RequestBody Client client) {
		Log.info("updating client {}",client.getUsername());
		try {
			clientService.registerClient(client);
		} catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
			throw new BadRequestException(e.getMessage());
		}
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/clients/{username}")
				.buildAndExpand(client.getUsername()).toUri();

		return ResponseEntity
				.created(location)
				.body(new ApiResponse(true,"User registered successfully"));
	}


	

	//PUT Requests

	@RequestMapping(value ="/clients", produces = MediaType.APPLICATION_JSON_VALUE, params = "id", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Client> update(@RequestParam int id, @RequestBody Client client) throws ResourceNotFoundException {

		
		Log.info("updatinging client {}",client.getUsername());
		Optional<Client> clientData = clientService.retrieveClient(id);

		if (clientData.isPresent()) {
			return new ResponseEntity<>(clientService.updateClient(client,id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	//DELETE Requests

	@RequestMapping(value ="/clients", produces = MediaType.APPLICATION_JSON_VALUE, params = "id", method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<HttpStatus> deleteClient(@RequestParam int id) {
		try {
			clientService.deleteClient(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
