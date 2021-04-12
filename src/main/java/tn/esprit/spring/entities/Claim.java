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
	@Column(name="id_problem")
	long idProblem ;
	
	
	
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",nullable=true )
	private Client client ;
	/*@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY,optional = true)
	@JoinColumn(name="delivery_id",nullable=true )
	private Deliveryman deli  ;





	public Claim(Deliveryman deli) {
		super();
		this.deli = deli;
	}





	public Deliveryman getDeli() {
		return deli;
	}





	public void setDeli(Deliveryman deli) {
		this.deli = deli;
	}*/




	public Claim(Long idclaim, String descreption, String subject_claim, boolean state, long idProblem, Client client) {
		super();
		this.idclaim = idclaim;
		this.descreption = descreption;
		this.subject_claim = subject_claim;
		State = state;
		this.idProblem = idProblem;
		this.client = client;
	}





	public Claim() {
		super();
	}





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
		return State;
	}





	public void setState(boolean state) {
		State = state;
	}





	public long getIdProblem() {
		return idProblem;
	}





	public void setIdProblem(long idProblem) {
		this.idProblem = idProblem;
	}





	public Client getClient() {
		return client;
	}





	public void setClient(Client client) {
		this.client = client;
	} 
	
	

}
