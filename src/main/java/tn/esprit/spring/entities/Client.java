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


	public Client(int id, String name, String email, String password, int phone_number,Adress adress) {
		super(phone_number, password, password, password, phone_number);
		this.adress=adress;
		// TODO Auto-generated constructor stub
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


	/** ceci est un peu compliqué je vais terminer eli shelin baaed narj3elha
	@OneToMany(mappedBy="client")
	private List<CommentProduct> comments;*/


}
