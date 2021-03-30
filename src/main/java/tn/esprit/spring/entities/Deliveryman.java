package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	//	return orders;
	//}

	
	//public void setOrders(Set<OrderC> orders) {
	//	this.orders = orders;
	//}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DeliveryMan(int id, String first_Name, String last_Name, String user_Name, String email, String password,
			int phone_number, int prime, int rank, String joblist, Set<OrderC> orders) {
		super(id, first_Name, last_Name, user_Name, email, password, phone_number, "DELIVERY_MAN");
		this.prime = prime;
		this.rank = rank;
		this.joblist = joblist;
		//this.orders = orders;
	}


	
	
	
	public DeliveryMan(int id, String first_Name, String last_Name, String user_Name, String email, String password,
			int phone_number) {
		super(id, first_Name, last_Name, user_Name, email, password, phone_number, "DELIVERY_MAN");
	
	}


}
