package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="DELIVERY_MAN")
public class Deliveryman  extends User implements Serializable {
	
	

	public Deliveryman(int id, String name, String email, String password, int phone_number) {
		super(id, name, email, password, phone_number);
		// TODO Auto-generated constructor stub
	}




	private static final long serialVersionUID = 1L;
	
	@Column(name="prime")
	int prime ;
	@Column(name="rank")
	int rank  ;
	@Column(name="joblist")
	String joblist;
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryman")
	private Set<OrderC> orders;

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

	
}
