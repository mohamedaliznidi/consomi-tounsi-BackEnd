package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="deliveryman")
public class Deliveryman implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long delivery_id;
	
	@Column(name="lastname")
	String lastname ;
	@Column(name="fristname")
	String FristName ;
	@Column(name="adress")
	String adress ;
	@Column(name="phonenumber")
	String phonenumber ;
	@Column(name="prime")
	int prime ;
	@Column(name="rank")
	int rank  ;
	@Column(name="joblist")
	String joblist;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=true )
	private User user  ;

	public Long getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(Long delivery_id) {
		this.delivery_id = delivery_id;
	}

	public Deliveryman() {
		super();
	}

	public Deliveryman(Long delivery_id, String lastname, String fristName, String adress, String phonenumber,
			int prime, int rank, String joblist, User user) {
		super();
		this.delivery_id = delivery_id;
		this.lastname = lastname;
		FristName = fristName;
		this.adress = adress;
		this.phonenumber = phonenumber;
		this.prime = prime;
		this.rank = rank;
		this.joblist = joblist;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFristName() {
		return FristName;
	}

	public void setFristName(String fristName) {
		FristName = fristName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

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
