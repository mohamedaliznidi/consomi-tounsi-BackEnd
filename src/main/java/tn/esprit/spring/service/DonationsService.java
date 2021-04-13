package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Donations;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repositry.Donationsrepositry;

@Service
public class DonationsService {
	@Autowired
	public Donationsrepositry donn ;
	
	public Donations save(Donations donations) {
		return donn.save(donations);
	}
	public Donations getDonationsById(int id) {
		return donn.findById(id).orElse(null);
	}


	
public void deleteDonations(int id ) {
		donn.deleteById(id);
	}



	public Donations updateDonations(Donations Donations) {
		Donations existingdonations=donn.findById(Donations.getId()).orElse(null);
		return donn.save(Donations);
		
		
	
}
	
	
}
