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
	
	
	
	public ClientPlus(int id, String name, String email, String password, int phone_number) {
		super(id, name, email, password, phone_number);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy="clientplus", cascade = CascadeType.ALL)
	private Set<Donation> donations;
}
