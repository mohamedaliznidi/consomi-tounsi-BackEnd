package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity

public class Basket implements Serializable {
	
	
	public Basket( int idBasket, boolean stateBasket, Set<Product> products) {
		super();
		this.idBasket = idBasket;
		this.stateBasket = stateBasket;
		this.products = products;
	}

	private static final long serialVersionUID = 1L;
	
	@Id

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBasket;


	private boolean stateBasket;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> products;
	
	@OneToOne (mappedBy = "basket")
	private Client client;

	public int getIdBasket() {
		return idBasket;
	}

	public void setIdBasket(int idBasket) {
		this.idBasket = idBasket;
	}

	public boolean isStateBasket() {
		return stateBasket;
	}

	public void setStateBasket(boolean stateBasket) {
		this.stateBasket = stateBasket;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
