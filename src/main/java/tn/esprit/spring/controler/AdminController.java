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

import tn.esprit.spring.entities.Admin;

import tn.esprit.spring.service.IAdminService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AdminController {

	
	@Autowired
	private IAdminService AdminService;
	
	//GET Requests 

		@GetMapping("/admin")
		List<Admin> all() {
			return AdminService.retrieveAllAdmins();
		}

		@GetMapping("/admin/{id}")
		public ResponseEntity<Admin> one(@PathVariable int id) {

			Optional<Admin> adminData = AdminService.retrieveAdmin(id);
			if (adminData.isPresent()) {
				return new ResponseEntity<Admin>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		}
		
		//POST Requests

		@PostMapping("/admin")
		public ResponseEntity<Admin> createAdmin(@RequestBody Admin a) {
			try {
				AdminService.addAdmin(a);
				return new ResponseEntity<>( HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//PUT Requests

		@PutMapping("/admin/{id}")
		public ResponseEntity<Admin> update(@PathVariable("id") int id, @RequestBody Admin a) {
			Optional<Admin> adminData = AdminService.retrieveAdmin(id);

			if (adminData.isPresent()) {
				return new ResponseEntity<>(AdminService.updateAdmin(id , a), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

		
		//DELETE Requests
		
		@DeleteMapping("/admin/{id}")
		public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") int id) {
			try {
				AdminService.deleteAdmin(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}



}
