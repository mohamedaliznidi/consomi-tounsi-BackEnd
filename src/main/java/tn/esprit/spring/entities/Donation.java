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
	
	
	/**
	 * @param id
	 * @param type
	 * @param state
	 * @param clientplus
	 * @param clientpluss
	 */
	public Donation(int id, Donation_Type type, boolean state, ClientPlus clientplus, Set<ClientPlus> clientpluss) {
		this.id = id;
		this.type = type;
		this.state = state;
		this.clientplus = clientplus;
		this.clientpluss = clientpluss;
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public Donation_Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Donation_Type type) {
		this.type = type;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * @return the clientplus
	 */
	public ClientPlus getClientplus() {
		return clientplus;
	}

	/**
	 * @param clientplus the clientplus to set
	 */
	public void setClientplus(ClientPlus clientplus) {
		this.clientplus = clientplus;
	}

	/**
	 * @return the clientpluss
	 */
	public Set<ClientPlus> getClientpluss() {
		return clientpluss;
	}

	/**
	 * @param clientpluss the clientpluss to set
	 */
	public void setClientpluss(Set<ClientPlus> clientpluss) {
		this.clientpluss = clientpluss;
	}


}





