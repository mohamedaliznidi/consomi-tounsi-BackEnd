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
	
	
	/**
	 * @param prime
	 * @param rank
	 * @param joblist
	 */
	public Deliveryman(int prime, int rank, String joblist) {
		this.prime = prime;
		this.rank = rank;
		this.joblist = joblist;
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




	/**
	 * @return the prime
	 */
	public int getPrime() {
		return prime;
	}




	/**
	 * @param prime the prime to set
	 */
	public void setPrime(int prime) {
		this.prime = prime;
	}




	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}




	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}




	/**
	 * @return the joblist
	 */
	public String getJoblist() {
		return joblist;
	}




	/**
	 * @param joblist the joblist to set
	 */
	public void setJoblist(String joblist) {
		this.joblist = joblist;
	}

	
}
