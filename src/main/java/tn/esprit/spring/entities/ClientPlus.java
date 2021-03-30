package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity

@DiscriminatorValue("PLUS")
public class ClientPlus extends Client implements Serializable {
	
	public ClientPlus(int id, String first_Name, String last_Name, String user_Name, String email, String password,
			int phone_number, String user_Role, Set<OrderC> orderc, Adress adress, Set<Claim> claim, Basket basket,
			Event event, Set<Event> events, Set<Subject> subjects) {
		super(id, first_Name, last_Name, user_Name, email, password, phone_number, orderc, adress, claim, basket,
				event, events, subjects);
	}

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="clientplus", cascade = CascadeType.ALL)
	private Set<Donation> donations;
	
	@OneToOne (mappedBy = "clientplus")
	private Sheet sheet;

	
	public ClientPlus(int id, String first_Name, String last_Name, String user_Name, String email, String password,
			int phone_number, String user_Role, Set<OrderC> orderc, Adress adress, Set<Claim> claim, Basket basket,
			Event event, Set<Event> events, Set<Subject> subjects, Set<Donation> donations, Sheet sheet) {
		super(id, first_Name, last_Name, user_Name, email, password, phone_number, orderc, adress, claim,
				basket, event, events, subjects);
		this.donations = donations;
		this.sheet = sheet;
	}
}
