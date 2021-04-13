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
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "T_adresse")
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
	private Long id;
	private String road;
	private int postalCode;
	private String delegation;
	private String localite;
	private int number;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	private CodeP codep;

	@OneToOne(mappedBy="shippingAdress")
	OrderC orderC;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="adress" )
	private Set<Client> client;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getDelegation() {
		return delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocality(String localite) {
		this.localite = localite;
	}

	public CodeP getCodep() {
		return codep;
	}

	public void setCodep(CodeP codep) {
		this.codep = codep;
	}

	public OrderC getOrderC() {
		return orderC;
	}

	public void setOrderC(OrderC orderC) {
		this.orderC = orderC;
	}

	public Set<Client> getClient() {
		return client;
	}

	public void setClient(Set<Client> client) {
		this.client = client;
	}

	public Adress(Long id, String road, int postalCode, String delegation, String localite, CodeP codep,
			tn.esprit.spring.entities.OrderC orderC, Set<Client> client) {
		super();
		this.id = id;
		this.road = road;
		this.postalCode = postalCode;
		this.delegation = delegation;
		this.localite = localite;
		this.codep = codep;
		this.orderC = orderC;
		this.client = client;
	}
	
	
	
	

}
