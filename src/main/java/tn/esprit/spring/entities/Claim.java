package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="claim")
public class Claim implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long idclaim;
	@Column(name="Descreption")
	String descreption;
	@Column(name="Subject_claim")
	String subject_claim ;
	@Column(name="State")
	boolean State ; 
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=true )
	private Client client ; 
	
	public Long getIdClaim() {
		return idclaim;
	}
	public void setIdClaim( Long idclaim) {
		this.idclaim = idclaim;
	}
	public String getDescreption() {
		return descreption;
	}
	public Claim() {
		super();
	}
	public Claim(Long idclaim, String descreption, String subject_claim, boolean state, Client client) {
		super();
		this.idclaim = idclaim;
		this.descreption = descreption;
		this.subject_claim = subject_claim;
		State = state;
		this.client = client;
	}
	public Long getIdclaim() {
		return idclaim;
	}
	public void setIdclaim(Long idclaim) {
		this.idclaim = idclaim;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public String getSubject_claim() {
		return subject_claim;
	}
	public void setSubject_claim(String subject_claim) {
		this.subject_claim = subject_claim;
	}
	public boolean isState() {
		return State;
	}
	public void setState(boolean state) {
		State = state;
	}

	
	
	
	
	
	
	
	

}
