package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity

@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="CLIENT_TYPE")

@Table(name="CLIENT")
public class Client extends User implements Serializable {
	
	


	

	public Client(int id, String name, String email, String password, int phone_number) {
		super(id, name, email, password, phone_number);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	//relation orderc
	@OneToMany (cascade = CascadeType.ALL, mappedBy="client" )
	private Set<OrderC> orderc;
	
	//adress
	@ManyToOne
	private Adress adress;
	
	//basket
	@OneToOne
	private Basket basket;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CL_EVT_ID")
	private Event event;
	
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Event> events ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Subject> subjects;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Claim> claim;

	/**
	 * @return the orderc
	 */
	public Set<OrderC> getOrderc() {
		return orderc;
	}

	/**
	 * @param orderc the orderc to set
	 */
	public void setOrderc(Set<OrderC> orderc) {
		this.orderc = orderc;
	}

	/**
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	/**
	 * @return the basket
	 */
	public Basket getBasket() {
		return basket;
	}

	/**
	 * @param basket the basket to set
	 */
	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @return the events
	 */
	public Set<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	/**
	 * @return the subjects
	 */
	public Set<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	/**
	 * @return the claim
	 */
	public Set<Claim> getClaim() {
		return claim;
	}

	/**
	 * @param claim the claim to set
	 */
	public void setClaim(Set<Claim> claim) {
		this.claim = claim;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
