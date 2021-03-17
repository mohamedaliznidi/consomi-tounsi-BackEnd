package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
@Entity

@DiscriminatorValue("PLUS")
public class ClientPlus extends Client{

	@ManyToMany(mappedBy="clientplus", cascade = CascadeType.ALL)
	private Set<Donation> donations;
}
