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

	public String getUser_Role() {
		return User_Role;
	}

	public void setUser_Role(String user_Role) {
		User_Role = "CLIENT" ;
	}

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



	public Client(int id, String first_Name, String last_Name, String user_Name, String email, String password,
			int phone_number, Set<OrderC> orderc, Adress adress, Set<Claim> claim, Basket basket,
			Event event, Set<Event> events, Set<Subject> subjects) {
		super(id, first_Name, last_Name, user_Name, email, password, phone_number, "CLIENT");
		this.orderc = orderc;
		this.adress = adress;
		this.claim = claim;
		this.basket = basket;
		this.event = event;
		this.events = events;
		this.subjects = subjects;
	}


	/** ceci est un peu compliqué je vais terminer eli shelin baaed narj3elha
	@OneToMany(mappedBy="client")
	private List<CommentProduct> comments;*/


}
