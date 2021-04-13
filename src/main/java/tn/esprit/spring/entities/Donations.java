package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Donations implements Serializable
{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Donations_ID")
	private int id;
	
@ManyToOne(cascade=CascadeType.ALL)
Product products;	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Donations(int id) {
		super();
		this.id = id;
	}



	public Donations(Product products) {
		super();
		this.products = products;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public Donations() {
		super();
	} 

}
