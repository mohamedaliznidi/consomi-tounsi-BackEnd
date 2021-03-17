package tn.esprit.spring.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.*;

import tn.esprit.spring.repositry.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class Deliverymancontroller {
	
	@Autowired
	 private Deliverymanrepositry deliveryRepository;
	
	/*
		
	    @PostMapping(value="/add1", produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody ResponseEntity<Deliveryman >   add1(@RequestBody   Deliveryman cat1) throws Exception 
		{
			return new ResponseEntity<>( this.deliveryRepository.saveAndFlush(cat1),HttpStatus.CREATED);
			
		}*/

	@PostMapping("/adddelevry")
	public void add(@RequestBody  Deliveryman  cat1)
	{
		this.deliveryRepository.save(cat1);
		
	}
		
		@GetMapping("/cat1")
		
		public List<Deliveryman> getAll(){
			return this.deliveryRepository.findAll();
		}
		
		@RequestMapping(value = "/findcat1/{lastname}", method = RequestMethod.GET)
		@ResponseBody
		public List<Deliveryman> findStudents123(@PathVariable String lastname) {
			List<Deliveryman> studentResponse = (List<Deliveryman>) deliveryRepository. getDeliveryByDeliveryname(lastname);
			return studentResponse;
		}
        
		@PutMapping("/update/{delivery_id}")
		@ResponseBody
		public Deliveryman updatedeliveryman(@PathVariable("delivery_id") Long delivery_id, @RequestBody Deliveryman deliveryman) {
			Deliveryman d =deliveryRepository.getDeliveryById(delivery_id);
			d.setJoblist(deliveryman.getJoblist());
			d.setPrime(deliveryman.getPrime());
			d.setRank(deliveryman.getRank());
		    
		
		
		deliveryRepository.save(d);
		    
		return d;  
		    }

		
		
		

@DeleteMapping("/delete/{delivery_id}")
public String deleteman(@PathVariable("delivery_id") Long delivery_id) {
	Deliveryman Deliveryman = deliveryRepository.findById(delivery_id)
      .orElseThrow(() -> new IllegalArgumentException("Invalid deliveryman Id:" + delivery_id));
    deliveryRepository.delete(Deliveryman);
    return "redirect:/index"; }}

