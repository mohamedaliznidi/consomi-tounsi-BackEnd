package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity

public class Adress implements Serializable {
	
	
	public Adress(int id, tn.esprit.spring.entities.codeP codeP, String road, int number) {
		super();
		this.id = id;
		this.codeP = codeP;
		this.road = road;
		this.number = number;
		
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="CodeP")
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private codeP codeP;
	
	private String road;

	private int number;

	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<OrderC> orderc;
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<Client> client;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public codeP getCodeP() {
		return codeP;
	}
	public void setCodeP(codeP codeP) {
		this.codeP = codeP;
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
	public Set<OrderC> getOrderc() {
		return orderc;
	}
	public void setOrderc(Set<OrderC> orderc) {
		this.orderc = orderc;
	}
	public Set<Client> getClient() {
		return client;
	}
	public void setClient(Set<Client> client) {
		this.client = client;
	}
	
}
