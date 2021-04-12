package tn.esprit.spring.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("event")
public class Eventcontroller {
	@Autowired
	private EventService service;
	
	@PostMapping("/addevent")
	public Event addevent(@RequestBody Event event) {
		return service.save(event);
	}

	@GetMapping("/event/{id}")
	public Event findById(@PathVariable int id) {
		return service.getEventById(id);
	}
	
	@PutMapping("/update")
	public Event updateEvent(@RequestBody Event event) {
		return service.updateEvent(event);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable int id) {
		return service.deleteEvent(id);
	}
	

}


