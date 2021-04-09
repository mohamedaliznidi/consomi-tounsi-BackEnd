package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity

public class Donation implements Serializable {
	
	
	public Donation(int id, Donation_Type type, boolean state) {
		this.id = id;
		this.type = type;
		this.state = state;
		
	}

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="DONATION_ID")
	private int id ; 

	@Column(name="DONATION_TYPE")
	@Enumerated(EnumType.STRING)
	private Donation_Type type;

	@Column(name="DONATION_STATE")
	private boolean state;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CLP_DON_ID")
	private ClientPlus clientplus;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<ClientPlus> clientpluss;
	
	
	
	
	//Getters&Setters
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public Donation_Type getType() {
		return type;
	}


	public void setType(Donation_Type type) {
		this.type = type;
	}

	
	public boolean isState() {
		return state;
	}

	
	public void setState(boolean state) {
		this.state = state;
	}
	
}





