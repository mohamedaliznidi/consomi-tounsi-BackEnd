package tn.esprit.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repositry.Eventrepositry;

@Service
public class EventService {
	@Autowired
	public Eventrepositry evn ;
	
	public Event save(Event event) {
		return evn.save(event);
	}
	
	public Event getEventById(int id) {
		return evn.findById(id).orElse(null);
	}
	
	public String deleteEvent(int id) {
		evn.deleteById(id);
		return "Event removed!!"+id;
	}
	public Event updateEvent(Event Event) {
		Event existingevent=evn.findById(Event.getId()).orElse(null);
		existingevent.setName(Event.getName());
		existingevent.setStartDate(Event.getStartDate());
		existingevent.setEndDate(Event.getEndDate());
		existingevent.setTime(Event.getTime());
		return evn.save(Event);
	}
}