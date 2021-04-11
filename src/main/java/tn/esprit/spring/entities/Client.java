package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;





@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="CLIENT_TYPE")
@Table(name="CLIENT")
public class Client extends User implements Serializable {
	
	


public Client(int id, String name, String email, String password, int phone_number,Adress adress) {
		super(id, name, email, password, phone_number);
		this.adress=adress;
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@OneToMany (cascade = CascadeType.ALL, mappedBy="client" )
	private Set<OrderC> orderc;
	
	public Client(int id, String name, String email, String password, int phone_number, Set<OrderC> orderc,
			Adress adress, Set<Claim> claim, Basket basket, Event event, Set<Event> events, Set<Subject> subjects
			/**,List<CommentProduct> comments*/) {
		super(id, name, email, password, phone_number);
		this.orderc = orderc;
		this.adress = adress;
		this.claim = claim;
		this.basket = basket;
		this.event = event;
		this.events = events;
		this.subjects = subjects;
		//this.comments = comments;
	}

	
	public Client(int id, String name, String email, String password, int phone_number) {
		super(id, name, email, password, phone_number);
	}

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
	

	
	//@JsonBackReference
    //@JsonIgnore

	

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






	//private List<CommentProduct> comments;
	
	
	@OneToMany(mappedBy="client")
	private List<CommentProduct> comments;
	private List<CommentProduct> getComments(){
		return comments;
	}
	
	public void setComments (List<CommentProduct> comments){
		this.comments=comments;
	}


	public Client(int id, String name, String email, String password, int phone_number, Set<OrderC> orderc,
			Adress adress, Set<Claim> claim, Basket basket, Event event, Set<Event> events, Set<Subject> subjects,
			List<CommentProduct> comments) {
		super(id, name, email, password, phone_number);
		this.orderc = orderc;
		this.adress = adress;
		this.claim = claim;
		this.basket = basket;
		this.event = event;
		this.events = events;
		this.subjects = subjects;
		this.comments = comments;
	}


	public Client() {
		super();
	}
	
/**
	public void assignCommentProductToThisClient(
			List<CommentProduct> comments){
		this.setComments (comments);
			for (CommentProduct c : comments)
			{c.setClient(this);	
	}
		
	}
	*/
	
}
