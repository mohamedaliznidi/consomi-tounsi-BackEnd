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

@Entity 

@Table(name="claim")
public class Claim implements Serializable {
	
	
	public Claim(Long idclaim, String description, String subject_claim, boolean state) {
		super();
		this.idclaim = idclaim;
		this.description = description;
		this.subject_claim = subject_claim;
		this.state = state;
	}


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long idclaim;
	@Column(name="Description")
	String description;
	@Column(name="Subject_claim")
	String subject_claim ;
	@Column(name="State")
	boolean state ; 
	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Client client ;


	public Long getIdclaim() {
		return idclaim;
	}


	public void setIdclaim(Long idclaim) {
		this.idclaim = idclaim;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSubject_claim() {
		return subject_claim;
	}


	public void setSubject_claim(String subject_claim) {
		this.subject_claim = subject_claim;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	} 
	

}
