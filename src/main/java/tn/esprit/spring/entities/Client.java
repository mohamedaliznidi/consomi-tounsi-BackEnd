package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="CLIENT_TYPE")

public class Client extends User implements Serializable {

	

	private static final long serialVersionUID = 1L;

	@OneToMany (cascade = CascadeType.ALL, mappedBy="client" )
	private Set<OrderC> orderc;

	@ManyToOne
	private Adress adress;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Claim> claim;


	@OneToOne
	private Basket basket;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CL_EVT_ID")
	private Event event;
	@ManyToMany (cascade = CascadeType.ALL)
	private Set<Event> events ;



	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Subject> subjects;
	
	

	@OneToMany(mappedBy="client")
	private List<CommentProduct> comments;
	
	

	public Client(int id, @NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password, int phone_number, String Role, String first_Name,
			String last_Name, Instant createdAt, Instant updatedAt, boolean active) {
		super(id, user_Name, email, password, phone_number, Role, first_Name, last_Name, createdAt, updatedAt, active);
	
	}



	public Client(@NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		super(user_Name, email, password);
		
	}



	public Client(User user) {
		super(user);
		
	}



	
	public Set<OrderC> getOrderc() {
		return orderc;
	}



	public void setOrderc(Set<OrderC> orderc) {
		this.orderc = orderc;
	}



	public Adress getAdress() {
		return adress;
	}



	
	public void setAdress(Adress adress) {
		this.adress = adress;
	}



	
	public Set<Claim> getClaim() {
		return claim;
	}



	
	public void setClaim(Set<Claim> claim) {
		this.claim = claim;
	}



	
	public Basket getBasket() {
		return basket;
	}



	
	public void setBasket(Basket basket) {
		this.basket = basket;
	}



	
	public Event getEvent() {
		return event;
	}



	
	public void setEvent(Event event) {
		this.event = event;
	}



	
	public Set<Event> getEvents() {
		return events;
	}



	
	public void setEvents(Set<Event> events) {
		this.events = events;
	}



	
	public Set<Subject> getSubjects() {
		return subjects;
	}



	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}



	public List<CommentProduct> getComments() {
		return comments;
	}



	
	public void setComments(List<CommentProduct> comments) {
		this.comments = comments;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Client(User user, Set<OrderC> orderc, Adress adress, Set<Claim> claim, Basket basket, Event event,
			Set<Event> events, Set<Subject> subjects, List<CommentProduct> comments) {
		super(user);
		this.orderc = orderc;
		this.adress = adress;
		this.claim = claim;
		this.basket = basket;
		this.event = event;
		this.events = events;
		this.subjects = subjects;
		this.comments = comments;
	}


	
	


}
