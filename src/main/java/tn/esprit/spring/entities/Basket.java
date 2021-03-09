package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Basket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBasket;
	private boolean stateBasket;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> productss;

}
