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

import tn.esprit.spring.entities.ProductManager;
import tn.esprit.spring.exception.BadRequestException;
import tn.esprit.spring.exception.EmailAlreadyExistsException;
import tn.esprit.spring.exception.ResourceNotFoundException;
import tn.esprit.spring.exception.UsernameAlreadyExistsException;
import tn.esprit.spring.payload.ApiResponse;
import tn.esprit.spring.service.ProductManagerServiceImpl;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductManagerController {
	
	@Autowired
	private ProductManagerServiceImpl pmService;
	
	private static final Logger Log = LogManager.getLogger(ProductManagerController.class);

	//GET Requests

	@RequestMapping(value ="/managers", produces = MediaType.APPLICATION_JSON_VALUE, params = "username", method = RequestMethod.GET)
	@ResponseBody
		public ResponseEntity<?> findManager(@RequestParam String username) {
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
		
		@RequestMapping(value ="/managers", produces = MediaType.APPLICATION_JSON_VALUE, params = "id", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<?> one(@RequestParam int id) {

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

			return  ResponseEntity
					.created(location)
					.body(new ApiResponse(true,"User registered successfully"));
		}
		
		
		 
		//PUT Requests

		 @RequestMapping(value ="/managers", produces = MediaType.APPLICATION_JSON_VALUE, params = "id", method = RequestMethod.PUT)
			@ResponseBody
			public ResponseEntity<ProductManager> update(@RequestParam int id, @RequestBody ProductManager pm) {

				Log.info("updating manager {}",pm.getUsername());
				Optional<ProductManager> pmData = pmService.retrieveManager(id);

				if (pmData.isPresent()) {
					return new ResponseEntity<>(pmService.updateManager(pm,id), HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			
			//DELETE Requests

		 @RequestMapping(value ="/managers", produces = MediaType.APPLICATION_JSON_VALUE, params = "id", method = RequestMethod.DELETE)
			@ResponseBody
			@PreAuthorize("hasRole('Admin')")
			public ResponseEntity<HttpStatus> deleteManager(@RequestParam int id) {
				try {
					pmService.deleteManager(id);
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				} catch (Exception e) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

}
