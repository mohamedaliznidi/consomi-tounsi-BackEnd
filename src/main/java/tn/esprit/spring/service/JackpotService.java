package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Donations;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.repositry.Jackpotrepositry;

@Service
public class JackpotService {
	@Autowired
	public Jackpotrepositry jck ;
	
	public Jackpot save(Jackpot jackpot) {
		return jck.save(jackpot);
	}
	
	public Jackpot getJackpotById(int id) {
		return jck.findById(id).orElse(null);
	}
	
	public List<Jackpot> findAll(){
		return jck.findAll();
	}
	public String deleteJackpot(int id) {
		jck.deleteById(id);
		return "Jackpot  removed!!"+id;
	}
	public Jackpot updateJackpot(Jackpot Jackpot) {
		Jackpot existingjackpot=jck.findById(Jackpot.getId()).orElse(null);
		existingjackpot.setName(Jackpot.getName());
		existingjackpot.setImage(Jackpot.getImage());
		return jck.save(Jackpot);
	}
}
