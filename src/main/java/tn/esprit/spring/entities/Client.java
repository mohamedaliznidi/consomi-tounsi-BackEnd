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
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="CLIENT_TYPE")
@Table(name="CLIENT")
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
	 * @return the comments
	 */
	public List<CommentProduct> getComments() {
		return comments;
	}



	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<CommentProduct> comments) {
		this.comments = comments;
	}



	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	


}
