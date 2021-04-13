package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Donation;

import tn.esprit.spring.repositry.Donationrepositry;


@Service
public class DonationService {
	@Autowired
	public Donationrepositry don ;
	
	public Donation save(Donation donation) {
		return don.save(donation);
	}
	
	public Donation getDonationById(int id) {
		return don.findById(id).orElse(null);
	}
	
	public String deleteDonation(int id) {
		don.deleteById(id);
		return "Donation removed!!"+id;
	}
	public Donation updateDonation(Donation Donation) {
		Donation existingdonation=don.findById(Donation.getId()).orElse(null);
		existingdonation.setType(Donation.getType());
		existingdonation.setState(Donation.getState());
		return don.save(Donation);
	}
}
