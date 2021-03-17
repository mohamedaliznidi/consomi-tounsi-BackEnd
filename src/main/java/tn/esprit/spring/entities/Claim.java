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

@Table(name="claim")
public class Claim implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	//properties
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	Long idclaim;
	@Column(name="Descreption")
	String descreption;
	@Column(name="Subject_claim")
	String subject_claim ;
	@Column(name="State")
	boolean state ; 
	
	
	// Relations
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=true )
	private Client client ;


	public Long getIdclaim() {
		return idclaim;
	}


	public void setIdclaim(Long idclaim) {
		this.idclaim = idclaim;
	}


	public String getDescreption() {
		return descreption;
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
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	} 
	

}
