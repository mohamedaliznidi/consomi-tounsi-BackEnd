package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Donations;
import tn.esprit.spring.entities.Jackpot;
import tn.esprit.spring.service.JackpotService;

@RestController
@RequestMapping("jackpot")
public class Jackpotcontroller {
	@Autowired
	private JackpotService service;
	
	@PostMapping("/addjackpot")
	public Jackpot addjackpot(@RequestBody Jackpot jackpot) {
		return service.save(jackpot);
	}
	
	@GetMapping("/jackpot/{id}")
	public Jackpot findById(@PathVariable int id) {
		return service.getJackpotById(id);
	}
	@GetMapping("/jackpots")
	public List<Jackpot> allJackpots() {
	    return service.findAll();
	}
	
	@PutMapping("/update")
	public Jackpot updateJackpot(@RequestBody Jackpot jackpot) {
		return service.updateJackpot(jackpot);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteJackpot(@PathVariable int id) {
		return service.deleteJackpot(id);
	}

}
