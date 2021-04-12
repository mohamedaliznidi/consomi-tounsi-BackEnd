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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity

public class Donation implements Serializable {
	

	public Donation(int id, Donation_Type type, int state) {


		this.id = id;
		this.type = type;
		this.state = state;
		
	}

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="DONATION_ID")
	private int id ; 

	@Column(name="DONATION_TYPE")
	@Enumerated(EnumType.STRING)
	private Donation_Type type;

	@Column(name="DONATION_STATE")
	private int state;

	public Donation(int id, Donation_Type type, int state, Set<Sheet> sheet) {
		super();
		this.id = id;
		this.type = type;
		this.state = state;
		this.sheet = sheet;
	}

	public Donation() {
		super();
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy="donation")
	private Set<Sheet> sheet;
	
	
	public Donation() {
		super();
	}




	public Set<Sheet> getSheet() {
		return sheet;
	}




	public void setSheet(Set<Sheet> sheet) {
		this.sheet = sheet;
	}




	public Donation(int id, Donation_Type type, boolean state, Set<Sheet> sheet) {
		super();
		this.id = id;
		this.type = type;
		this.state = state;
		this.sheet = sheet;
	}




	public int getId() {
		return id;
	}

	
	public Set<Sheet> getSheet() {
		return sheet;
	}


	public void setSheet(Set<Sheet> sheet) {
		this.sheet = sheet;
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


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}

	
}





