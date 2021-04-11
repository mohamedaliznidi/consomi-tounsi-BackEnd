package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="DELIVERY_MAN")
public class DeliveryMan  extends User implements Serializable {

	

	private static final long serialVersionUID = 1L;

	@Column(name="prime")
	int prime ;
	@Column(name="rank")
	int rank  ;
	@Column(name="joblist")
	String joblist;




	//@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryman")
	//private Set<OrderC> orders;

	//Getters&Setters


	public int getPrime() {
		return prime;
	}


	public void setPrime(int prime) {
		this.prime = prime;
	}



	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}



	public String getJoblist() {
		return joblist;
	}



	public void setJoblist(String joblist) {
		this.joblist = joblist;
	}

	
	//public Set<OrderC> getOrders() {
	//return orders;
	//}

	
	//public void setOrders(Set<OrderC> orders) {
	//	this.orders = orders;
	//}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public DeliveryMan(int id, @NotBlank @Size(max = 15) String user_Name,
			@NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password, int phone_number,
			String Role, String first_Name, String last_Name, Instant createdAt, Instant updatedAt, boolean active) {
		super(id, user_Name, email, password, phone_number, Role, first_Name, last_Name, createdAt, updatedAt, active);
		
	}


	public DeliveryMan(@NotBlank @Size(max = 15) String user_Name, @NotBlank @Size(max = 40) @Email String email,
			@NotBlank @Size(max = 100) String password) {
		super(user_Name, email, password);
		
	}


	public DeliveryMan(User user) {
		super(user);
		
	}


	public DeliveryMan(User user, int prime, int rank, String joblist) {
		super(user);
		this.prime = prime;
		this.rank = rank;
		this.joblist = joblist;
		//this.orders = orders;
	}

	

	
	
	

}
