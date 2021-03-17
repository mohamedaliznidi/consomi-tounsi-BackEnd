package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
@Entity

@DiscriminatorValue("PLUS")
public class ClientPlus extends Client implements Serializable {
	
	
	public ClientPlus(Set<OrderC> orderc, Adress adress, Basket basket, Event event, Set<Event> events,
			Set<Subject> subjects, Set<Claim> claim) {
		super(orderc, adress, basket, event, events, subjects, claim);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="clientplus", cascade = CascadeType.ALL)
	private Set<Donation> donations;
}
