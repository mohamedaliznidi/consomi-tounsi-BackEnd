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

public class Adress implements Serializable {
	
	public Adress() {
		super();
	}
	//Constructor 
	public Adress( String road, int number ,CodeP codep) {
		super();
		this.codep = (CodeP) codep;
		this.road = road;
		this.number = number;
		
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="ID_ADRESS")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String road;
	private int number;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CodeP codep;

	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<OrderC> orderc;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<Client> client;
	
	//Getters&Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
