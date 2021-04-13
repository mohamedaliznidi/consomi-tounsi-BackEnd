package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.service.DonationsService;
import tn.esprit.spring.entities.Donations;
import tn.esprit.spring.repositry.Donationsrepositry;

@RestController
@RequestMapping("donations")
public class DonationsController {
	@Autowired
	private DonationsService service;
	
	@Autowired
	Donationsrepositry donrep;
	
	
	
	@GetMapping("/donations/{id}")
	public Donations findDonationsById(@PathVariable int id) {
		return service.getDonationsById(id);
	}
	
	@GetMapping("/donationss")
	public List<Donations> allDonationss() {
	    return donrep.findAll();
	}
	
	@DeleteMapping("/deleteproductdonations/{id_donations}")
	public void deleteDonations(@PathVariable int id_donations ) {
		 service.deleteDonations(id_donations);
	}
	
	
	

}
